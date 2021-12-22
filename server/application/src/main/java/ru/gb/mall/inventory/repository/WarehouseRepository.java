package ru.gb.mall.inventory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.mall.inventory.entity.Warehouse;

public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Long> {
}
