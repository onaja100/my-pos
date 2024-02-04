package com.example.pos.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.item.Item;
import com.example.pos.item.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    
    @Autowired
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public CartService(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    public Item findOrderItem(String barcode) {
        Item item = itemRepository.findByBarcode(barcode);
        return item;
    }
    

    public CheckOutResponse calculatePrice(List<CheckOutRequest> cart) {
        CheckOutResponse checkResponse = new CheckOutResponse();
        List<CustomItem> items = new ArrayList<>();
        Double totalPrice = 0.0;
        Integer quantity = 0;
        
        for (CheckOutRequest addCart : cart) {
            Item item = itemRepository.findByBarcode(addCart.code());
            CustomItem customItem = new CustomItem(item);
            customItem.setQuantity(addCart.quantity());

            items.add(customItem);
            totalPrice += item.getPrice() * addCart.quantity();
            quantity += addCart.quantity();
        }
        checkResponse.setTotalOrders(quantity);
        checkResponse.setTotalPrice(totalPrice);
        checkResponse.setItems(items);
        checkResponse.setDateTime();

        saveToDatabase(checkResponse);
        return checkResponse;
    }
    public void saveToDatabase(CheckOutResponse checkOutResponse) {
        Integer lastId = cartRepository.findLastId();
       
        if (lastId == null || lastId == 0) {
            lastId = 1;
        } else {
            lastId += 1;
        }

        for (CustomItem customItem : checkOutResponse.getItem()) {
            AddCart newOrder = new AddCart();
            newOrder.setBuyid(lastId);
            newOrder.setCode(customItem.getBarcode());
            newOrder.setQuantity(customItem.getQuantity());
            newOrder.setPrice(customItem.getPrice());
            newOrder.setDateTime(java.time.LocalDateTime.now());
            cartRepository.save(newOrder);
        }
    }
}
