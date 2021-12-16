package ru.gb.mall.inventory.web;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.mall.inventory.entity.Product;
import ru.gb.mall.inventory.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.accepted().body(productService.add(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") long id) {
        if (!productService.isPresent(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product id:" + id + " not found");
        } else {
            productService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product id:" + id + " has been deleted");
        }
    }
}
