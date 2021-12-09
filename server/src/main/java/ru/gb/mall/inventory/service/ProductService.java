package ru.gb.mall.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.mall.inventory.entity.Product;
import ru.gb.mall.inventory.exception.EntityNotFoundException;
import ru.gb.mall.inventory.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), true).toList();
    }

    public Product findById(long id) {
        try {
            return productRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Product entity no found by id: " + id, e);
        }
    }

}
