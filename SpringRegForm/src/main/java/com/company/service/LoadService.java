package com.company.service;

import com.company.dto.LoadDTO;
import com.company.entity.Load;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class LoadService {
    private Load load;

    public void createLoad(LoadDTO loadDTO) {
        load = new Load();
        load.setStartPoint(loadDTO.getStartPoint());
        load.setEndPoint(loadDTO.getEndPoint());
        load.setWeight(loadDTO.getWeight());
                /*Load.builder()
                .startPoint(loadDTO.getStartPoint())
                .endPoint(loadDTO.getEndPoint())
                .weight(loadDTO.getWeight())
                .build();*/
        load.calculateShippingCost();
    }
}
