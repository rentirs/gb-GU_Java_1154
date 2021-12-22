package ru.gb.mall.inventory.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.gb.mall.inventory.exception.EntityNotFoundException;
import ru.gb.mall.inventory.mail.MailSenderException;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ApiError> handleNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MailSenderException.class})
    public ResponseEntity<ApiError> handleMailException(MailSenderException ex) {
        return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
