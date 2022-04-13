package com.cl.service.transaction;

import org.springframework.transaction.annotation.Propagation;

public interface TransactionService {

    Boolean trans(Integer type);

    void insertUser();

    void insertUserAddress();

    Propagation getType();

}
