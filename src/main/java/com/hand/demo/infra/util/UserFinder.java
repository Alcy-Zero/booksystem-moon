package com.hand.demo.infra.util;

import com.hand.demo.domain.entity.User;
import com.hand.demo.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFinder {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.findAllUser();
    }

}
