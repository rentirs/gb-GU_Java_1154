package ru.gb.mall.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.mall.inventory.entity.WarehouseItem;
import ru.gb.mall.inventory.entity.WarehouseKeeper;
import ru.gb.mall.inventory.mail.EmailService;
import ru.gb.mall.inventory.mail.message.EmailMessage;
import ru.gb.mall.inventory.repository.WarehouseItemRepository;
import ru.gb.mall.inventory.repository.WarehouseKeeperRepository;


@Service
public class WarehouseItemService {

    private final WarehouseItemRepository warehouseItemRepository;
    private final WarehouseKeeperRepository warehouseKeeperRepository;
    private final EmailService emailService;

    public WarehouseItemService(WarehouseItemRepository warehouseItemRepository, WarehouseKeeperRepository warehouseKeeperRepository, EmailService emailService) {
        this.warehouseItemRepository = warehouseItemRepository;
        this.warehouseKeeperRepository = warehouseKeeperRepository;
        this.emailService = emailService;
    }

    public WarehouseItem receiptInWarehouse(WarehouseItem warehouseItem) {
        WarehouseItem warehouseItem1 = warehouseItemRepository.findByWarehouseIdAndProductId(warehouseItem.getWarehouseId(), warehouseItem.getProductId());
        if (warehouseItem1 == null) {
            return warehouseItemRepository.save(warehouseItem1);
        }
        int newAmount = warehouseItem1.getAmount() + warehouseItem.getAmount();
        warehouseItem1.setAmount(newAmount);
        return warehouseItemRepository.save(warehouseItem1);
    }

    public WarehouseItem writeOffFromWarehouse(WarehouseItem warehouseItem) {
        WarehouseItem warehouseItem1 = warehouseItemRepository.findByWarehouseIdAndProductId(warehouseItem.getWarehouseId(), warehouseItem.getProductId());
        if (warehouseItem1 != null) {
            int amountInWarehouse = warehouseItem1.getAmount();
            int amountNeed = warehouseItem.getAmount();
            if (amountNeed <= amountInWarehouse) {
                warehouseItem1.setAmount(amountInWarehouse - amountNeed);
                WarehouseKeeper warehouseKeeper = warehouseKeeperRepository.findByWarehouseId(warehouseItem1.getWarehouseId());
                emailService.send(new EmailMessage("SenderPost", warehouseKeeper.getEmail(), "1",
                        "write-Off product id:" + warehouseItem1.getProductId() +
                                " amount: " + amountNeed +
                                " warehouse id:" + warehouseItem1.getWarehouseId() +
                                " left:" + warehouseItem1.getAmount()));
                return warehouseItem1;
            }
        } return null;
    }

}
