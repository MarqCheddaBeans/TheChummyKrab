package com.pluralsight.models;

public enum PattyType {

    KRABBY("Krabby Patty", 3),
    KELP("Kelp Patty", 4),
    CHUMMY_KRAB("Original Chummy Krab Patty", 2),
    NONE("No Patty", 0);

    private String displayName;
    private double price;

    PattyType(String displayName, double price){
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
