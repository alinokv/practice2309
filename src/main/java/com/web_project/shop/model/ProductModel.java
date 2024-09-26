package com.web_project.shop.model;

public class ProductModel {
    private int Id;
    private String name;
    private Double price;

    public ProductModel(int id, String Name, Double Price){
        Id = id;
        name = Name;
        price = Price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
