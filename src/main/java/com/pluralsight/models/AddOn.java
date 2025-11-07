package com.pluralsight.models;

//Will represent addons regular or premium
public class AddOn {

    //Create the properties of an addOn
    private String name;
    private double price;
    private boolean premium;

    //Beautiful constructor
    public AddOn(String name, double price, boolean premium){
        this.name = name;
        this.price = price;
        this.premium = premium;
    }

    //toString Override to print out my custom text which will display the add on name and if its premium
    @Override
    public String toString(){
        String addOnName = name;
        if(premium){
            addOnName += " [Premium]";
        }
        addOnName += " +$" + String.format("%.2f", price);
        return addOnName;
    }

    //Getterssss
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPremium() {
        return premium;
    }
}
