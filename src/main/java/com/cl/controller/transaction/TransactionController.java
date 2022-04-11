package com.cl.controller.transaction;

import com.cl.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public Boolean trans(Integer type) {
        return transactionService.trans(type);
    }
}
