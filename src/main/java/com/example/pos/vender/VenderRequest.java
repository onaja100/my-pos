package com.example.pos.vender;

record VenderRequest(
    String name,
    Integer qty_pack,
    Double price
) {
}