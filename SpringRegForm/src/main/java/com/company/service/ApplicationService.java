package com.company.service;

import com.company.dto.AppWeightAndCostDTO;
import com.company.dto.ApplicationDTO;
import com.company.dto.ReceiptsDTO;
import com.company.entity.Application;
import com.company.entity.Receipt;
import com.company.entity.User;
import com.company.exceptions.TransactionException;
import com.company.repository.ReceiptRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Data
@Service
@Slf4j
public class ApplicationService {
    private final int serviceCharge = 15;

    private Application application;

    private ReceiptsDTO receiptsDTO = new ReceiptsDTO();

    private final ReceiptRepository receiptRepository;

    public ApplicationService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public void addReceipt(Receipt receipt) {
        receiptsDTO.addReceipt(receipt);
    }

    public Receipt createReceipt(User user) {
        return Receipt.builder()
                .application(application)
                .cost(calculateCost())
                .user(user)
                .build();
    }

    private BigDecimal calculateCost() {
        Double weight = application.getWeight();
        double scale = 0;
        if (weight <= 0.5) {
            scale = 40;
        } else if (weight <= 1) {
            scale = 45;
        } else if (weight <= 2) {
            scale = 50;
        } else if (weight <= 5) {
            scale = 55;
        } else if (weight <= 10) {
            scale = 65;
        } else if (weight <= 20) {
            scale = 85;
        } else if (weight <= 30) {
            scale = 105;
        } else if (weight > 30) {
            scale = 105 + calculateExtraFee();
        }
        return new BigDecimal(scale + serviceCharge);
    }

    private double calculateExtraFee() {
        double extraFee = application.getWeight() - 30;
        return extraFee * 4.5;
    }

    public void addApplication(ApplicationDTO applicationDTO) {
        application =  Application.builder().weight(applicationDTO.getWeight()).build();
    }

    public AppWeightAndCostDTO getApplicationCost() {
        return AppWeightAndCostDTO.builder()
                .weight(application.getWeight())
                .cost(calculateCost())
                .build();
    }

    // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(User user, BigDecimal cost  /*Long id, double amount*/) throws TransactionException {
    /*    BankAccount account = this.findById(id);
        if (account == null) {
            throw new BankTransactionException("Account not found " + id);
        }*/

        BigDecimal newBalance = user.getBalance().add(cost);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new TransactionException(
                    "The money in the account '" + user.getId() + "' is not enough (" + user.getBalance() + ")");
        }
        user.setBalance(newBalance);
    }

    // Do not catch BankTransactionException in this method.
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = TransactionException.class)
    public void sendMoney(User user, Receipt receipt  /*Long fromAccountId, Long toAccountId, double amount*/) throws TransactionException {

        /*addAmount(toAccountId, amount);
        addAmount(fromAccountId, -amount);*/
        addAmount(user,receipt.getCost().multiply(BigDecimal.valueOf(-1)));

        receiptRepository.save(receipt);
        log.info("{}",user.getBalance());
        log.info("{saved}");
    }
}
