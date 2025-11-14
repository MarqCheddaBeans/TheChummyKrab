package com.pluralsight.models;

import com.pluralsight.models.combos.ComboMeal;
import com.pluralsight.models.combos.SignatureComboMeal;

import java.util.ArrayList;
import java.util.List;

//This will manage list of menu items and calc total
public class Order {

    //Create list of menu items
    private List<MenuItem> items;

    //constructor
    public Order(){
        this.items = new ArrayList<>();
    }

    //method to add an item to our menu item list that will be the users order
    public void addItem(MenuItem item){
        if( item != null){
            items.add(item);
        }
    }

    //method to remove items from order
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

    //Override toString from parent class object and format to look pretty
    @Override
    public String toString() {

        //Create String summary which we will concat order info
        String summary = "\n======================================================================================================================================================\n🧾 THE CHUMMY KRAB CHECKOUT 🧾\n";
        summary += "======================================================================================================================================================\n" ;


        //Check if customer has anything to order
        if (items.isEmpty()) {
            summary += "Your order is empty?!\n";
        } else {
            //Separate list by types
            List<ComboMeal> combos = new ArrayList<>();
            List<SignatureComboMeal> sigCombos = new ArrayList<>();
            List<KrabbyChumPatty> burgers = new ArrayList<>();
            List<Drink> drinks = new ArrayList<>();
            List<Side> sides = new ArrayList<>();

            //cycle through items and sort them into created lists
            for(MenuItem i : items) {
                if (i instanceof ComboMeal c) {
                    combos.add(c);
                } else if (i instanceof SignatureComboMeal s) {
                    sigCombos.add(s);
                } else if (i instanceof KrabbyChumPatty k) {
                    burgers.add(k);
                } else if (i instanceof Drink d) {
                    drinks.add(d);
                } else if (i instanceof Side s) {
                    sides.add(s);
                }
            }

                //check if order has that item before printing
                if(!sigCombos.isEmpty()){
                    summary += "\n Signature Combos: \n";
                    summary += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    for (SignatureComboMeal s : sigCombos) {
                        summary += s.sigComboInfo() + "\n";
                    }
                }

                if(!combos.isEmpty()){
                    summary += "\n Combos: \n";
                    summary += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    for (ComboMeal c : combos) {
                        summary += c.comboInfo() + "\n";
                    }
                }

                if(!burgers.isEmpty()){
                    summary += "\n Burgers: \n";
                    summary += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    for (KrabbyChumPatty b : burgers) {
                        //summary += "- " + b.getName() + " $" + String.format("%.2f", b.calculatePrice()) + "\n";
                        summary += b.burgerInfo();
                    }
                }

                if(!drinks.isEmpty()){
                    summary += "\n Drinks: \n";
                    summary += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    for (Drink d : drinks) {
                        summary += "- " + d.getSize() + " " + d.getName() + " $" + String.format("%.2f", d.calculatePrice()) + "\n";
                    }
                }

                if(!sides.isEmpty()){
                    summary += "\n Sides: \n";
                    summary += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    for (Side s : sides) {
                        summary += "- " + s.getSize() + " " + s.getName() + " $" + String.format("%.2f", s.calculatePrice()) + "\n";
                    }
                }

            }

            //calculate and concat the total of all addons
            summary += "======================================================================================================================================================\nTotal: $" + String.format("%.2f", calculateTotal()) + "\n======================================================================================================================================================\n";
        //return the variable containing all the items in the order including price , addons and if any are premium

        return summary;
        }

    }
