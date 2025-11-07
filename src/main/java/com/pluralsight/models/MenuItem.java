package com.pluralsight.models;

//Blueprint for all menu items
public abstract class MenuItem {

    //The properties
    private String name;
    private double price;

    //Our beautiful constructor
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Force children to individually calculate price
    public abstract double calculatePrice();

    //Getters you already know
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

}
