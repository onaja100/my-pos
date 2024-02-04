package com.example.pos.cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CheckOutRequest(
    @NotNull
    String code,

    @NotNull
    @Positive
    Integer quantity
) {
}
