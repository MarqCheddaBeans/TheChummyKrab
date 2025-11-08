package com.pluralsight.models;

//Will represent the drinks
public class Drink extends MenuItem{

    //Set up properties for a drink
    private Size size;

    //Constructor with super
    public Drink(String name, double price, Size size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String toString(){

        String info = "======================================================================================================================================================\n";
        info += getName() + " -  $" + String.format("%.2f", calculatePrice()) + "\n" ;
        info += "======================================================================================================================================================\n" ;

        return info;
    }

    @Override
    public double calculatePrice() {
        return getPrice() * size.getMultiplier();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
