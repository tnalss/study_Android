package com.example.a13_clone_mgc.main;

import java.io.Serializable;

public class ProductDTO implements Serializable {


    private int imageSrc,price;
    private String name,desc;

    public ProductDTO(int imageSrc, int price, String name, String desc) {
        this.imageSrc = imageSrc;
        this.price = price;
        this.name = name;
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
