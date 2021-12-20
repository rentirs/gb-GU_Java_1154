package ru.gb.mall.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.mall.inventory.entity.Product;
import ru.gb.mall.inventory.entity.Warehouse;
import ru.gb.mall.inventory.exception.EntityNotFoundException;
import ru.gb.mall.inventory.repository.ProductRepository;
import ru.gb.mall.inventory.repository.WarehouseRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;


@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> findAll() {
        return StreamSupport.stream(warehouseRepository.findAll().spliterator(), true).toList();
    }

    public Warehouse findById(long id) {
        try {
            return warehouseRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Warehouse entity not found by id: " + id, e);
        }
    }

    public Warehouse add(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteById(long id) {
        warehouseRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return warehouseRepository.existsById(id);
    }
}
