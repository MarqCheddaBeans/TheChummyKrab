package com.pluralsight.models;

//Enum to represent our constant patty types
public enum PattyType {

    //create constants for patty types
    KRABBY("Krabby Patty", 2.75),
    KELP("Kelp Patty", 3.25),
    CHUMMY_KRAB("Original Chummy Krab Patty", 2.25),
    NONE("No Patty", 0);

    //declare variables for constant values
    private String displayName;
    private double price;

    //constructor
    PattyType(String displayName, double price){
        this.displayName = displayName;
        this.price = price;
    }

    //getters
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
