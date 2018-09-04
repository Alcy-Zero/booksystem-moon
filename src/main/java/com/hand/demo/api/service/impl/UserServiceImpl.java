package com.hand.demo.api.service.impl;

import com.hand.demo.api.service.UserService;
import com.hand.demo.domain.entity.User;
import com.hand.demo.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void insertByUser(User user){
        userMapper.save(user);
    }


}
