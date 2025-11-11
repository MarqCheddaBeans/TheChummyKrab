package com.pluralsight.models;

//Blueprint for all menu items
public abstract class MenuItem {

    //The properties
    protected String name;
    protected double price;
    protected Size size;

    //Our beautiful constructor
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Overload constructor for the "Burgers" since names are fixed based on size
    public MenuItem(double price){
        this.price = price;
        this.name = null;
    }

    public MenuItem(String name){
        this.name = name;
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
