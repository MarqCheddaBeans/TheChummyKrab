package com.pluralsight.models.combos;

import com.pluralsight.models.MenuItem;

public class SignatureSide extends MenuItem {

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
