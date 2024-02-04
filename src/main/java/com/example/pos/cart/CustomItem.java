package com.example.pos.cart;

import com.example.pos.item.Item;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomItem extends Item {
    private Integer quantity;

    public CustomItem(Item item) {
        super.setId(item.getId());
        super.setName(item.getName());
        super.setCategory(item.getCategory());
        super.setPrice(item.getPrice());
        super.setBarcode(item.getBarcode());
    }
}
