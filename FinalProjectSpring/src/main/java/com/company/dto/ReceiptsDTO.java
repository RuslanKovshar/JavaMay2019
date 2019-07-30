package com.company.dto;

import com.company.entity.Receipt;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReceiptsDTO {
    List<Receipt> receipts = new ArrayList<>();

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public void deleteReceipt(int index) {
        receipts.remove(index);
    }
}
