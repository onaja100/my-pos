package com.example.pos.vender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequestMapping("/vender")
@RestController
public class VenderController {
    
    @Autowired
    private final VenderService venderService;

    public VenderController(VenderService venderService) {
        this.venderService = venderService;
    }   

    @Operation(summary = "List all venders")
    @ApiResponse(responseCode = "200", description = "List all venders", 
        content = {
            @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", 
            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = VenderListResponse.class))
        })
    @PostMapping("/list-venders")
    public List<Vender> listVenders() {
        return venderService.listVenders();
    }

    @Operation(summary = "add vender")
    @ApiResponse(responseCode = "201", description = "add vender", 
        content = {
            @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", 
            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = VenderResponse.class))
        })
    @PostMapping("/add-vender/{barcode}")
    public VenderResponse addVender(@RequestBody VenderRequest request, String barcode) {
        return venderService.addVender(request, barcode);
    }
}
