package com.cl.controller.transaction;

import com.cl.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trans")
public class TransactionController {

    @Autowired
    private List<TransactionService> transactionServices;

    @GetMapping("trans")
    public Boolean trans(Integer type) {
        Propagation propagation;
        TransactionService transactionService;
        propagation = getPropagation(type);
        if (propagation == null) {
            return false;
        }
        transactionService = getTransactionService(propagation);
        if (transactionService == null) {
            return false;
        }
        transactionService.insertUser();
        transactionService.insertUserAddress();
        return transactionService.trans(type);
    }

    private Propagation getPropagation(Integer type) {
        for (Propagation item :Propagation.values()) {
            if (type == item.value()) {
                return item;
            }
        }
        return null;
    }

    private TransactionService getTransactionService(Propagation propagation) {
        for (TransactionService item : transactionServices) {
            if (item.getType().equals(propagation)) {
                return item;
            }
        }
        return null;
    }

}
