package com.cl.service.impl.transaction;

import com.cl.mapper.transaction.UserAddressMapper;
import com.cl.mapper.transaction.UserMapper;
import com.cl.pojo.transaction.User;
import com.cl.pojo.transaction.UserAddress;
import com.cl.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionRequiredServiceImpl implements TransactionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean trans(Integer type) {
        insertUserAddress();
        insertUser();
        return true;
    }

    @Override
    public void insertUser() {
        userMapper.insert(new User(1L, "张三"));
        throw new RuntimeException();
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertUserAddress() {
        userAddressMapper.insert(new UserAddress(1L, "山东"));
    }

    @Override
    public Propagation getType() {
        return Propagation.REQUIRED;
    }
}
