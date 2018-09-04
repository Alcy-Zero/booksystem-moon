package com.hand.demo.infra.mapper;

import com.hand.demo.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    void save(User user);

    List<User> findAllUser();

}
