package com.demo.pojo;


import javax.persistence.*;

@Entity
@Table(name="product")
//@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private float price;
    @Column(name="cid")
    private int cid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Product() {
    }

    public Product(int id, String name, float price, int cid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product [id="+id+",name="+name+",price="+price+",cid="+cid+"]";

    }
}
