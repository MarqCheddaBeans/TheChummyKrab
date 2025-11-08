package com.pluralsight.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//This is what they came for(Main item)
public class KrabbyChumPatty extends MenuItem implements Modify {

    //We need properties, check for special option, hold addons

    private Size size;
    private boolean toasted;
    private PattyType patty;
    private BunType bun;
    private List<AddOn> addOns;

    //Constructor
    public KrabbyChumPatty(double price, Size size){
        super(price = size.getBase());
        this.size = size;
        this.toasted = false;
        this.patty = PattyType.NONE;
        this.bun = BunType.NONE;
        this.addOns = new ArrayList<>();
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
        //double total = getPrice(); // size.getBase() + patty.getPrice() + bun.getPrice();

       //total += addOns.stream()
               // .mapToDouble(a -> a.getPrice())
        //  .sum();

       return getPrice();
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

        return info;
    }

    //GetterSetter

    //Override getName() method so that we can name based on size
    @Override
    public String getName(){
        return size.getName();
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void setAddOns(List<AddOn> addOns) {
        this.addOns = addOns;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public List<AddOn> getAddOns() {
        return addOns;
    }
}
