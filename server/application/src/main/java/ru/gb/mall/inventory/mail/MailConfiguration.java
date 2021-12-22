package ru.gb.mall.inventory.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

//@Configuration
public class MailConfiguration {
    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.google.com");
        sender.setPort(587);
        sender.setUsername("<changeit>");
        sender.setPassword("<changeit>");

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smptp.auth", "true");
        props.put("mail.smptp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return sender;
    }
}
