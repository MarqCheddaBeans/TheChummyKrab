package com.pluralsight.models;

public enum BunType{

    KELPB("Kelp Bun",2.00),
    POTATO("Potato Bun",1.50),
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
