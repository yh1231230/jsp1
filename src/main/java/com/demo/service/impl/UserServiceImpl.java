package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> users= userMapper.findAll();
        return users;
    }

    @Override
    public int add(User user) {
        userMapper.add(user);
        return 1;
    }

    @Override
    public int delete(int id) {
        userMapper.delete(id);
        return 1;
    }

    @Override
    public User get(int id) {
        User user= userMapper.get(id);
        return user;
    }

    @Override
    public int update(User user) {
        userMapper.update(user);
        return 1;
    }
}
