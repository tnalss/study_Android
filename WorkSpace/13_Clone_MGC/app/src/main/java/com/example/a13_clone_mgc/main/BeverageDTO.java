package com.example.a13_clone_mgc.main;

import java.io.Serializable;

public class BeverageDTO implements Serializable {
    private int imageSrc;
    private String name,desc;

    public BeverageDTO(int imageSrc, String name, String desc) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.desc = desc;
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
