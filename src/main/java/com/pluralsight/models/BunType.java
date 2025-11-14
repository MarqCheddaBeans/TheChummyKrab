package com.pluralsight.models;

//Bun type enum to represent our types of buns and prices
public enum BunType{

    //Constants, bun types
    KELPB("Kelp Bun",2.00),
    POTATO("Potato Bun",1.50),
    SESAME("Sesame Bun", 1.75),
    NONE("No Bun", 0.00);

    public String displayName;
    public double price;

    BunType(String displayName, double price){
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName(){
        return displayName;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return displayName;
    }

}
