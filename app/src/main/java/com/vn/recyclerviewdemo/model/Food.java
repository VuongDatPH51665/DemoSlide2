package com.vn.recyclerviewdemo.model;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String name;
    private int price;
    private String address;
    private int Img;
    public Food(){
    }

    public Food(String name, int price, String address) {
        this.name = name;
        this.price = price;
        this.address = address;
    }

    public Food(String name, int price, String address, int img) {
        this.name = name;
        this.price = price;
        this.address = address;
        Img = img;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
