package com.cl.service.impl.transaction;

import com.cl.mapper.transaction.UserAddressMapper;
import com.cl.pojo.transaction.UserAddress;
import com.cl.service.transaction.TransactionCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionSupportsServiceImpl implements TransactionCommonService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public void trans(Integer type) {
        userAddressMapper.insert(new UserAddress(1L, "山东"));
        throw new RuntimeException();
    }

    @Override
    public Propagation getType() {
        return Propagation.SUPPORTS;
    }
}
