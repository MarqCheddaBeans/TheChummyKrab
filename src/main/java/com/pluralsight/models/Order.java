package com.pluralsight.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//This will manage list of menu items and calc total
public class Order {

    private List<MenuItem> items;

    public Order(){
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        if( item != null){
            items.add(item);
        }
    }

    public void removeItem(MenuItem item){
        items.remove(item);
    }

    //Calculate total price of items in our order
    public double calculateTotal(){
        return items.stream()
                .mapToDouble(MenuItem::calculatePrice)
                .sum();
    }

    //Getter for items in our list
    public List<MenuItem> getItems(){
        return items;
    }

    public String toString() {

        String summary = "Order summary:\n";

        if (items.isEmpty()) {
            summary += "You didnt order anything?!\n";
        } else {
            for (MenuItem i : items) {
                summary += "- " + i.getName() + " $" + String.format("%.2f", i.calculatePrice()) + "\n";

                //We want to add any addons to be displayed
                if(i instanceof Modify m){
                    List<AddOn> addOns = m.getAddOns();

                    if(addOns.isEmpty()){
                        summary += " • No addons\n";
                    }else{
                        for(AddOn a : addOns){
                            summary += "    • " + a.getName();
                            if( a.isPremium()){
                                summary += " [Premium]";
                            }
                            summary += "  +$" + String.format("%.2f", a.getPrice()) + "\n";
                        }
                    }
                }
            }
            summary += "Total: $" + String.format("%.2f", calculateTotal()) + "\n";
        }
        return summary;
    }

    }

