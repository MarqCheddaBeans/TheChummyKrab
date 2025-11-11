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
    private String name;

    //Constructor
    public KrabbyChumPatty(double price, Size size){
        super(price);
        this.size = size;
        this.toasted = false;
        this.patty = PattyType.NONE;
        this.bun = BunType.NONE;
        this.addOns = new ArrayList<>();
    }
    //Overloaded constructor
    public KrabbyChumPatty(double price, String name){
        super(price);
        this.name = name;
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
    public Size getSize(){
        return this.size;
    }

    //Calculate price for burger taking into account addons, bun type, size and patty type
    @Override
    public double calculatePrice(){

        double total =size.getBase()+ patty.getPrice() + bun.getPrice();

        if( !addOns.isEmpty()){
            total += addOns.stream()
                    .mapToDouble(a -> a.getPrice())
                    .sum();
        }
        if(isToasted()){
            total += 50;
        }

       return total;
    }

    @Override
    public String toString(){

        String info = "======================================================================================================================================================\n";
        info += getName() + " -  $" + String.format("%.2f", calculatePrice()) + "\n" ;
        info += "======================================================================================================================================================\n" ;

        info += "\n    • " + size + "  +$" + String.format("%.2f", size.getBase());
        info += "\n    • " + bun.displayName + "  +$" + String.format("%.2f", bun.getPrice());
        info += "\n    • " + patty.getDisplayName() + "  +$" + String.format("%.2f", patty.getPrice()) + "\n";

        if (addOns.isEmpty()|| addOns.equals(null)){
            info += "    • No addons\n";
        }else {
            for( AddOn a : addOns){
                info += "    • " + a.getName();
                if(a.isPremium()) info += " [Premium]";
                info += "  +$" + String.format("%.2f", a.getPrice()) + "\n";
            }
        }

        if(isToasted()){
            info += "    • Toasted Bun +$50\n";
        } else{
            info += "    • Cold Bun\n";
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

    @Override
    public List<AddOn> getAddOns() {
        return addOns;
    }

    @Override
    public boolean isToasted() {
        return toasted;
    }

    @Override
    public PattyType getPatty() {
        return patty;
    }

    public void setPatty(PattyType patty) {
        this.patty = patty;
    }

    @Override
    public BunType getBun() {
        return bun;
    }

    public void setBun(BunType bun) {
        this.bun = bun;
    }

    public void setName(String name) {
        this.name = name;
    }
}
