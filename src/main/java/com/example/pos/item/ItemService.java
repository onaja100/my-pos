package com.example.pos.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.exceptions.InternalServerException;

import java.util.List;


@Service
public class ItemService {
    
    @Autowired
    private final ItemRepository itemRepository;
    private final UpdateItemRepository updateItemRepository;

    public ItemService(ItemRepository itemRepository, UpdateItemRepository updateItemRepository) {
        this.itemRepository = itemRepository;
        this.updateItemRepository = updateItemRepository;
    }

    public List<ItemResponse> ListItem() { // Change List<PosResponse> to List<PosResponse>
        return itemRepository
                .findAll()
                .stream()
                .map(item -> new ItemResponse(item.getId(), item.getName(), item.getCategory(), item.getPrice(), item.getBarcode())) // Change new ListItem to new PosResponse
                .toList();
    }

    public ItemResponse addItem(Item item) {
        try {
            itemRepository.save(item);
        } catch (Exception e) {
            throw new InternalServerException("Failed to add item");
        }

        return new ItemResponse(item.getId(), item.getName(), item.getCategory(), item.getPrice(), item.getBarcode());
    }

    public ItemResponse findByBarcode(String barcode) {
        // Item item = itemRepository.findById(id).orElse(null);
        Item item = itemRepository.findByBarcode(barcode);
        if (item == null) {
            throw new InternalServerException("Failed to find item");
        }
        return new ItemResponse(item.getId(), item.getName(), item.getCategory(), item.getPrice(), item.getBarcode());
    }

    public List<ItemResponse> findByCategory(String category) {
        return itemRepository
                .findByCategory(category)
                .stream()
                .map(item -> new ItemResponse(item.getId(), item.getName(), item.getCategory(), item.getPrice(), item.getBarcode()))
                .toList();
    }

    public ItemResponse updatePrice(String code, Double price) {
        // Item item = itemRepository.findById(id).orElse(null);
        Item item = itemRepository.findByBarcode(code);
        if (item == null) {
            throw new InternalServerException("Failed to find item");
        }
        UpdateItem updateItem = new UpdateItem();
        // updateItem.setId_item(id);
        updateItem.setPrice(item.getPrice());
        updateItem.setDate(java.time.LocalDate.now());
        updateItem.setCode(item.getBarcode());
        updateItemRepository.save(updateItem);
        item.setPrice(price);
        itemRepository.save(item);
        return new ItemResponse(item.getId(), item.getName(), item.getCategory(), item.getPrice(), item.getBarcode());
    }
}
