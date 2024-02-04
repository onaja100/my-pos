package com.example.pos.item;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateItemPriceRequest(
    @NotNull
    @Positive
    Double price
) {
}