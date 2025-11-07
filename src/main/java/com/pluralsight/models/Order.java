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

    //Override toString from parent class object and formal to look pretty
    @Override
    public String toString() {

        //Create String summary which we will concat order info
        String summary = "Order summary:\n";

        //Check if customer has anything to order
        if (items.isEmpty()) {
            summary += "You didnt order anything?!\n";
        } else {
            //cycle through items list and add name and price of each item
            for (MenuItem i : items) {
                summary += "- " + i.getName() + " $" + String.format("%.2f", i.calculatePrice()) + "\n";

                //We want to add any addons to be displayed
                if(i instanceof Modify m){
                    //Create AddOn list to store items implementing Modify( meaning they can have addOns)
                    List<AddOn> addOns = m.getAddOns();

                    //Check if the item implementing Modify actually has any addons
                    if(addOns.isEmpty()){
                        summary += " • No addons\n";
                    }else{
                        //cycle through addons and add the name
                        for(AddOn a : addOns){
                            summary += "    • " + a.getName();

                            //if add on is premium, add premium tag
                            if( a.isPremium()){
                                summary += " [Premium]";
                            }
                            //concat the price of addon
                            summary += "  +$" + String.format("%.2f", a.getPrice()) + "\n";
                        }
                    }
                }
            }
            //calculate and concat the total of all addons
            summary += "Total: $" + String.format("%.2f", calculateTotal()) + "\n";
        }
        //return the variable containing all the items in the order including price , addons and if any are premium
        return summary;
    }

    }