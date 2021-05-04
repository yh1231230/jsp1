package com.demo.service;


import com.demo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    public int add(User user);

    public int delete(int id);

    public User get(int id);

    public int update(User user);
}
