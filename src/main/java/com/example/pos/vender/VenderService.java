package com.example.pos.vender;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class VenderService {
    
    @Autowired
    private final VenderRepository venderRepository;

    public VenderService(VenderRepository venderRepository) {
        this.venderRepository = venderRepository;
    }

    public List<Vender> listVenders() {
        return venderRepository.findAll();
    } 


    public VenderResponse addVender(VenderRequest request, String code) {
        Vender vender = new Vender();

        vender.setName(request.name());
        vender.setCode(code);
        vender.setQty_pack(request.qty_pack());
        vender.setPrice(request.price());

        venderRepository.save(vender);

        return new VenderResponse(vender.getId(), vender.getName(), vender.getCode(), vender.getQty_pack(), vender.getPrice());
    }
}
