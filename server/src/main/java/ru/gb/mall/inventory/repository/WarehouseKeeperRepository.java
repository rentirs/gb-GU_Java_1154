package ru.gb.mall.inventory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.mall.inventory.entity.WarehouseKeeper;

public interface WarehouseKeeperRepository extends PagingAndSortingRepository<WarehouseKeeper, Long> {
    WarehouseKeeper findByWarehouseId(Long warehouseiD);
}
