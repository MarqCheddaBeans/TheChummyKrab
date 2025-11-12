package com.pluralsight.models;

public class SignatureSide extends MenuItem{

    public SignatureSide(String name){
        super(name);
    }

    @Override
    public double calculatePrice(){
        return 0;
    }

    @Override
    public String toString(){
        String info = "Side: \n";
        info += "    " + getName() + "\n" ;
        return info;
    }
}
