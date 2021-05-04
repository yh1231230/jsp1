package com.demo.mapper;


import com.demo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user ")
    List<User> findAll();

    @Insert("insert into user (name) values (#{name})")
    public int add(User user);

    @Delete("delete from user where id = #{id}")
    public int delete(int id);

    @Select("select * from user where id = #{id}")
    public User get(int id);

    @Update("update user set name = #{name} where id = #{id}")
    public int update(User user);

}
