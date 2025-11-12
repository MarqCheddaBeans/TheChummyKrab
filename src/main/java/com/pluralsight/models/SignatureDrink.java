package com.pluralsight.models;

public class SignatureDrink extends MenuItem{

    public SignatureDrink(String name){
        super(name);
    }

    @Override
    public double calculatePrice(){
        return 0;
    }

    @Override
    public String toString(){
        String info = "Drink: \n";
        info += "    " + getName() + "\n" ;

        return info;
    }
}
