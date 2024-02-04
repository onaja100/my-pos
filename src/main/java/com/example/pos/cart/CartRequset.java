package com.example.pos.cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CartRequset(
    @NotNull
    @Positive
    Integer itemId, 

    @NotNull
    @Positive
    Integer quantity
    ) {
}
