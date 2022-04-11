package com.cl.service.impl.transaction;

import com.cl.mapper.transaction.UserMapper;
import com.cl.service.transaction.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private UserMapper userMapper;


    @Override
    public Boolean trans(Integer type) {
        return null;
    }




}
