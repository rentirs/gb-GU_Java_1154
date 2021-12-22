package ru.gb.mall.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.mall.inventory.entity.WarehouseKeeper;
import ru.gb.mall.inventory.exception.EntityNotFoundException;
import ru.gb.mall.inventory.repository.WarehouseKeeperRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;


@Service
public class WarehouseKeeperService {

    private final WarehouseKeeperRepository warehouseKeeperRepository;

    public WarehouseKeeperService(WarehouseKeeperRepository warehouseKeeperRepository) {
        this.warehouseKeeperRepository = warehouseKeeperRepository;
    }

    public List<WarehouseKeeper> findAll() {
        return StreamSupport.stream(warehouseKeeperRepository.findAll().spliterator(), true).toList();
    }

    public WarehouseKeeper findById(long id) {
        try {
            return warehouseKeeperRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Warehouse entity not found by id: " + id, e);
        }
    }

    public WarehouseKeeper add(WarehouseKeeper warehouseKeeper) {
        return warehouseKeeperRepository.save(warehouseKeeper);
    }

    public void deleteById(long id) {
        warehouseKeeperRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return warehouseKeeperRepository.existsById(id);
    }
}
