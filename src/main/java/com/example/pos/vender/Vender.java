package com.example.pos.vender;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;


@Entity(name = "venders")
@Data
public class Vender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String code;
    Integer qty_pack;
    Double price;
}
