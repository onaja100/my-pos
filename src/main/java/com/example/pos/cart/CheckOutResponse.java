package com.example.pos.cart;

import java.time.LocalDateTime;
import java.util.List;

public class CheckOutResponse {
    private List<CustomItem> customItems;
    private Double totalPrice;
    private Integer totalOrder;
    private LocalDateTime dateTime;

    public void setTotalOrders(Integer quantity) {
        this.totalOrder = quantity;
    }

    public void setItems(List<CustomItem> item) {
        this.customItems = item;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public Integer getTotalOrders() {
        return this.totalOrder;
    }

    public List<CustomItem> getItem() {
        return customItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
