package com.example.pos.cart;

public record CartResponse(Integer id, Integer itemId, Integer quantity, Double price) {
}
