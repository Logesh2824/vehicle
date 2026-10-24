package com.example.vehicle.dto.request;

public class CategoryRequest {
    private String name;
    private String description;

    public CategoryRequest(){

    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDescription(String description){
        this.description=description;
    }
}
