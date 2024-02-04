package com.example.pos.cart;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

// import com.example.pos.Item;
import com.example.pos.item.Item;

import java.util.List;


@RequestMapping("/cart")
@RestController
public class CartController {
    
    private final CartService cartService;
    
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "find item by barcode")
    @ApiResponse(responseCode = "200", description = "find item by barcode", 
        content = {
            @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", 
            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Item.class))
        })
    @GetMapping("/order-id/{barcode}")
    public ResponseEntity<Item> findItem(@PathVariable(name = "barcode") String barcode) {
        Item response = cartService.findOrderItem(barcode);
        return ResponseEntity.ok(response);
    }
    
    @Operation(summary = "calculate price")
    @ApiResponse(responseCode = "200", description = "calculate total price and checkout", 
        content = {
            @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", 
            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = AddCartResponse.class))
        })
    @PostMapping("/calculate-price")
    public CheckOutResponse requestMethodName(@RequestBody List<CheckOutRequest> checkOutRequests) {
        CheckOutResponse totalPrice = cartService.calculatePrice(checkOutRequests);

        return totalPrice;
    }
}
