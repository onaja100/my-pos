package com.example.pos.item;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;

import java.util.List;

@RequestMapping("/item")
@RestController
public class ItemController {
 
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "list all item")
    @ApiResponse(responseCode = "200", description = "list all item", 
        content = {
            @Content(mediaType = "application/json", 
            array = @ArraySchema(schema = @Schema(implementation = ItemResponse.class)))
        })  
    @GetMapping("")
    public List<ItemResponse> getItem() {
        return itemService.ListItem();
    }

    @Operation(summary = "add new item")
    @ApiResponse(responseCode = "201", description = "add new item don't pass id it will be generated automatically", 
        content = {
            @Content(mediaType = "application/json", 
            schema = @Schema(implementation = ItemResponse.class))
        })
    @PostMapping("")
    public ResponseEntity<ItemResponse> addItem(@RequestBody Item item) {
        ItemResponse response =  itemService.addItem(item);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "find item by barcode")
    @ApiResponse(responseCode = "200", description = "find item by id", 
        content = {
            @Content(mediaType = "application/json", 
            schema = @Schema(implementation = ItemResponse.class))
        })
    @GetMapping("/{barcode}")
    public ItemResponse findByBarcode(@PathVariable(name = "barcode") String barcode) {
        return itemService.findByBarcode(barcode);
    }

    @Operation(summary = "filter by category")
    @ApiResponse(responseCode = "200", description = "filter by category", 
        content = {
            @Content(mediaType = "application/json", 
            array = @ArraySchema(schema = @Schema(implementation = ItemResponse.class)))
        })
    @GetMapping("/category/{category}")
    public List<ItemResponse> findByCategory(@PathVariable(name = "category") String category) {
        return itemService.findByCategory(category);
    }

    @Operation(summary = "update price")
    @ApiResponse(responseCode = "200", description = "update price", 
        content = {
            @Content(mediaType = "application/json", 
            schema = @Schema(implementation = ItemResponse.class))
        })
    @PostMapping("/update/{barcode}")
    public ItemResponse updatePrice(@PathVariable(name = "barcode") String barcode, @RequestBody UpdateItemPriceRequest price) {
        return itemService.updatePrice(barcode, price.price());
    }
}
