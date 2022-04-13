package com.cl.service.impl.transaction;

import com.cl.mapper.transaction.UserAddressMapper;
import com.cl.mapper.transaction.UserMapper;
import com.cl.pojo.transaction.User;
import com.cl.pojo.transaction.UserAddress;
import com.cl.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public Boolean trans(Integer type) {
        return insertUser() && insertUserAddress();
    }

    @Override
    public Boolean insertUser() {
        User user = new User();
        user.setName("张三");
        user.setId(1L);
        return userMapper.insert(user) > 0;
    }

    @Override
    public Boolean insertUserAddress() {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(1L);
        userAddress.setAddress("山东");
        return userAddressMapper.insert(userAddress) > 0;
    }
}
