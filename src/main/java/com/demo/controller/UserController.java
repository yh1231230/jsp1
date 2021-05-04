package com.demo.controller;

import com.demo.dao.UserDAO;
import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @RequestMapping("/listUser")
    public String listUser(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<User> us=userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(us);
        m.addAttribute("page", page);
        return "listUser";
    }

    @RequestMapping("/addUser")
    public String listUser(User u)throws  Exception{
        userMapper.add(u);
        return "redirect:listUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User u)throws Exception{
        userMapper.delete(u.getId());
        return "redirect:listUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User u)throws Exception{
        userMapper.update(u);
        return "redirect:listUser";//重定向到listUser
    }

    @RequestMapping("/editUser")
    public String listUser(int id, Model m)throws Exception{
        User u=userMapper.get(id);
        m.addAttribute("u",u);
        return "editUser";//定位到editUser.jsp视图
    }
}
