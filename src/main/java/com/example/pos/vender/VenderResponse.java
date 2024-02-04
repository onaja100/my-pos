package com.example.pos.vender;

public record VenderResponse (
    Integer id,
    String name,
    String code,
    Integer qty_pack,
    Double price
) {
    
}
