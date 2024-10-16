package com.web_project.shop.model;

public class CategoryModel {
    private int id;

    private String name;
    private String description;

    public CategoryModel(int Id, String Name, String Description){
        id = Id;
        name = Name;
        description = Description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
