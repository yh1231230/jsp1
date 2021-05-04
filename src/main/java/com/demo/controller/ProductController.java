package com.demo.controller;

import com.demo.mapper.ProductMapper;
import com.demo.pojo.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductMapper productMapper;

    @GetMapping("/products")
    public String listProduct(Model m,@RequestParam(value ="start",defaultValue = "0") int start, @RequestParam(value ="size",defaultValue = "5") int size){
        PageHelper.startPage(start,size,"id desc");
        List<Product> productList=productMapper.getList();
        PageInfo<Product> page = new PageInfo<>(productList);
        m.addAttribute("page", page);
        return "listProduct";
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable int id, Model m){
        Product product=productMapper.getOne(id);
        System.out.println(product);
        m.addAttribute("p", product);
        return "getProduct";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam int id,@RequestParam String name,@RequestParam float price,@RequestParam int cid){
        Product product=new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setCid(cid);
        productMapper.add(product);
        return "redirect:/products";
    }

    @RequestMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model m){
        Product product=productMapper.getOne(id);
        System.out.println(product);
        m.addAttribute("p", product);
        return "editProduct";
    }



    @PutMapping("/products/edit/{id}")
    public String updateProduct(Product product) throws Exception{
      productMapper.update(product);
        return "redirect:/products";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(Product p){
        productMapper.delete(p.getId());
        return "redirect:/products";
    }
}
