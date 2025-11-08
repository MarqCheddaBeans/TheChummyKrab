package com.pluralsight.models;

//represents any sides also menu item
public class Side extends MenuItem{

    //The properties of a side
    private Size size;

    //The super constructor
    public Side(String name, double price, Size size) {
        super(name, price);
        this.size = size;
    }

    //Overload the parents methods
    @Override
    public double calculatePrice() {
        return getPrice() * size.getMultiplier();
    }

    //ToString to store Side info for later
    @Override
    public String toString(){
        String info = "======================================================================================================================================================\n";
        info += getName() + " -  $" + String.format("%.2f", calculatePrice()) + "\n" ;
        info += "======================================================================================================================================================\n" ;

        return info;
    }

    //getters
    public Size getSize() {
        return size;
    }
}
