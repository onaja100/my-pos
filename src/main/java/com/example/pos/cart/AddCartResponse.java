package com.example.pos.cart;

import java.util.List;

public record AddCartResponse(List<AddCart> cart, double totalPrice) {
}
