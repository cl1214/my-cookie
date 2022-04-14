package com.cl.service.transaction;

import org.springframework.transaction.annotation.Propagation;

public interface TransactionCommonService {

    void trans(Integer type);

    Propagation getType();
}
