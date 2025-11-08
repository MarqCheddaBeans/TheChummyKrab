package com.pluralsight.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//This is what they came for(Main item)
public class KrabbyChumPatty extends MenuItem implements Modify {

    //We need properties, check for special option, hold addons

    private Size size;
    private boolean specialOption;
    private List<AddOn> addOns;
    //Constructor

    public KrabbyChumPatty(double price, Size size){
        super(price);
        this.size = size;
        this.addOns = new ArrayList<>();
        this.specialOption = false;
    }


    //Override methods from extend and implements
    @Override
    public void addAddOn(AddOn addOn){
        addOns.add(addOn);
    }

    @Override
    public void removeAddOn(AddOn addOn){
        addOns.remove(addOn);
    }

    @Override
    public double calculatePrice(){
        double total = getPrice() * size.getMultiplier();

       total += addOns.stream()
                .mapToDouble(a -> a.getPrice())
                .sum();

       if (specialOption){
           //Extra money for special option
           total += 2.50;
       }
       return total;
    }

    @Override
    public String toString(){

        String info = "======================================================================================================================================================\n";
        info += getName() + " -  $" + String.format("%.2f", calculatePrice()) + "\n" ;
        info += "======================================================================================================================================================\n" ;

        if (addOns.isEmpty()){
            info += "    • No addons\n";
        }else {
            for( AddOn a : addOns){
                info += "    • " + a.getName();
                if(a.isPremium()) info += " [Premium]";
                info += "  +$" + String.format("%.2f", a.getPrice()) + "\n";
            }
        }
        if (specialOption) {
            info += "    • Special Option!!/n";
        }
        return info;
    }

    //GetterSetter

    //Override getName() method so that we can name based on size
    @Override
    public String getName(){
        return size.getName();
    }

    public Size getSize() {
        return size;
    }

    public boolean isSpecialOption() {
        return specialOption;
    }

    @Override
    public List<AddOn> getAddOns() {
        return addOns;
    }
}
