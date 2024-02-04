package com.example.pos.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
    @Query("SELECT p FROM items p WHERE p.category = ?1")
    List<Item> findByCategory(String category);

    @Query("SELECT p FROM items p WHERE p.barcode = ?1")
    Item findByBarcode(String code);

}