package ru.gb.mall.inventory.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.mall.inventory.entity.Warehouse;
import ru.gb.mall.inventory.entity.WarehouseKeeper;
import ru.gb.mall.inventory.service.WarehouseKeeperService;
import ru.gb.mall.inventory.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouseKeepers")
public class WarehouseKeeperController {

    private final WarehouseKeeperService warehouseKeeperService;

    public WarehouseKeeperController(WarehouseKeeperService warehouseKeeperService) {
        this.warehouseKeeperService = warehouseKeeperService;
    }

    @GetMapping
    public ResponseEntity<List<WarehouseKeeper>> findAll() {
        return ResponseEntity.ok(warehouseKeeperService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseKeeper> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(warehouseKeeperService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<WarehouseKeeper> addWarehouse(@RequestBody WarehouseKeeper warehouseKeeper) {
        return ResponseEntity.accepted().body(warehouseKeeperService.add(warehouseKeeper));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWarehouse(@PathVariable("id") long id) {
        if (!warehouseKeeperService.isPresent(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Warehouse keeper id:" + id + " not found");
        } else {
            warehouseKeeperService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Warehouse keeper id:" + id + " has been deleted");
        }
    }
}
