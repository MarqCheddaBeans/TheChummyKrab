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
        String summary = "\n======================================================================================================================================================\n🧾 THE CHUMMY KRAB CHECKOUT 🧾\n";
        summary += "======================================================================================================================================================\n" ;


        //Check if customer has anything to order
        if (items.isEmpty()) {
            summary += "Your order is empty?!\n";
        } else {
            //cycle through items list and add name and price of each item
            for (MenuItem i : items) {

                if(i instanceof ComboMeal c){
                    summary += c.comboInfo();
                }

                summary += "\n- " + i.getName() + " $" + String.format("%.2f", i.calculatePrice()) + "\n";

                //We want to add any addons to be displayed
                if(i instanceof Modify m){
                    summary += "    • " + m.getSize() + "  +$" + String.format("%.2f", m.getSize().getBase()) + "\n";

                    summary += "    • " + m.getBun() + "  +$" + String.format("%.2f", m.getBun().getPrice()) + "\n";

                    summary += "    • " + m.getPatty() + "  +$" + String.format("%.2f", m.getPatty().getPrice()) + "\n";

                    //Create AddOn list to store items implementing Modify( meaning they can have addOns)
                    List<AddOn> addOns = m.getAddOns();

                    //Check if the item implementing Modify actually has any addons
                    if(addOns.isEmpty()){
                        summary += " \t• No addons\n";
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
                    if(m.isToasted()){
                        summary += "    • Consented Toasted Bun +$50.00\n";
                    }else{
                        summary += "    • Cold Bun\n";
                    }
                }
            }
            //calculate and concat the total of all addons
            summary += "======================================================================================================================================================\nTotal: $" + String.format("%.2f", calculateTotal()) + "\n======================================================================================================================================================\n";
        }
        //return the variable containing all the items in the order including price , addons and if any are premium
        return summary;
    }

    }