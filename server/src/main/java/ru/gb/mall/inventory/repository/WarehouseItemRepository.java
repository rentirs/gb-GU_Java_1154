package ru.gb.mall.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.mall.inventory.entity.Warehouse;
import ru.gb.mall.inventory.entity.WarehouseItem;

public interface WarehouseItemRepository extends CrudRepository<WarehouseItem, Long> {
    WarehouseItem findByWarehouseIdAndProductId(Long warehouseId, Long productId);
}
