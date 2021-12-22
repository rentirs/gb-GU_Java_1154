package ru.gb.mall.inventory.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.mall.inventory.entity.Warehouse;
import ru.gb.mall.inventory.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> findAll() {
        return ResponseEntity.ok(warehouseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(warehouseService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        return ResponseEntity.accepted().body(warehouseService.add(warehouse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWarehouse(@PathVariable("id") long id) {
        if (!warehouseService.isPresent(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Warehouse id:" + id + " not found");
        } else {
            warehouseService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Warehouse id:" + id + " has been deleted");
        }
    }
}
