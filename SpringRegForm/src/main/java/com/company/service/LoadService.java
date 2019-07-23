package com.company.service;

import com.company.dto.cargo_dto.*;
import com.company.entity.cargo.*;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class LoadService {
    private Baggage baggage;
    private double cost;

    public void create(LoadDTO loadDTO) {
        baggage = new Load(loadDTO);
    }

    public void create(TiresDTO tiresDTO) {
        baggage = new Tires(tiresDTO);
    }

    public void create(DocumentDTO documentDTO) {
        baggage = new Document(documentDTO);
    }

    public void create(PalletDTO palletDTO) {
        baggage = new Pallet(palletDTO);
    }

    public void makeCashAccount() {
        cost = baggage.calculateShippingCost();
    }
}
