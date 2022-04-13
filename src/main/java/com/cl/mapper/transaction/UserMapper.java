package com.cl.mapper.transaction;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cl.pojo.transaction.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
