package com.pluralsight.models;

//Blueprint for all menu items
public abstract class MenuItem {

    //The properties
    private String name;
    private double price;
    private Size size;

    //Our beautiful constructor
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
        this.size = size;
    }

    //Overload constructor for the "Burgers" since names are fixed based on size
    public MenuItem(double price){
        this.price = price;
        this.name = null;
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
