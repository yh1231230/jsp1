package com.demo.mapper;


import com.demo.pojo.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductMapper {
    @Select("select * from product")
    public List<Product> getList();

    @Select("select * from product where id = #{id}")
    public Product getOne(int id);

    @Insert("insert into product (id,name,price,cid) values (#{id},#{name},#{price},#{cid}) ")
    public int add(Product product);

    @Delete("delete from product where id = #{id}")
    public void delete(int id);

    @Update("update product set name= #{name}, price= #{price},cid= #{cid} where id = #{id}")
    public int update(Product product);
}
