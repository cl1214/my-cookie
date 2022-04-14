package com.cl.service.impl.transaction;

import com.cl.mapper.transaction.UserMapper;
import com.cl.pojo.transaction.User;
import com.cl.service.transaction.TransactionCommonService;
import com.cl.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private List<TransactionCommonService> transactionServices;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean trans(Integer type) {
        TransactionCommonService transactionService = getTransactionService(type);
        if (transactionService == null) {
            return false;
        }
        insertUser();
        try {
            transactionService.trans(type);
        } catch (Exception e) {
            // 捕捉异常，同一个事务则外部事务也同时回滚或者提交
            System.out.println("内层事务调用失败");
        }
        //throw new RuntimeException();
        return true;
    }

    private void insertUser() {
        userMapper.insert(new User(1L, "张三"));
    }

    private Propagation getPropagation(Integer type) {
        for (Propagation item :Propagation.values()) {
            if (type == item.value()) {
                return item;
            }
        }
        return null;
    }

    private TransactionCommonService getTransactionService(Integer type) {
        Propagation propagation = getPropagation(type);
        if (propagation == null) {
            return null;
        }
        for (TransactionCommonService item : transactionServices) {
            if (item.getType().equals(propagation)) {
                return item;
            }
        }
        return null;
    }
}
