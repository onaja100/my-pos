package com.example.pos.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<AddCart, Integer>{
    @Query("SELECT MAX(a.buyid) FROM cart a")
    public Integer findLastId();
}