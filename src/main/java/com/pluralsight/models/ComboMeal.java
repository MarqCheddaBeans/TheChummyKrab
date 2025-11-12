package com.pluralsight.models;
import java.util.ArrayList;
import java.util.List;

//class to represent our combo meal object, will deal with menu items
public class ComboMeal extends MenuItem{

    //combo consists of burger, drink and side
    private KrabbyChumPatty burger;
    private Drink drink;
    private Side side;

    //need the super constructor
    public ComboMeal(KrabbyChumPatty burger, Drink drink, Side side){
        super("Combo Meal");
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    //child inherits parents classes and overrides
    @Override
    public double calculatePrice(){

        //Calculate price will sum up the total price of all items in combo and takes 10 percent off
        double total = 0;

        if(burger != null) total += burger.calculatePrice();
        if(drink != null) total += drink.calculatePrice();
        if(side != null) total += side.calculatePrice();

        //combo will be a 10 percent discount from price of total items
        total *= .90;

        return total;
    }

    @Override
    public String getName(){
        return burger.getName() + " Combo";
    }

    @Override
    public String toString() {
        String summary = getName() + "\n";
        summary += "   - Burger: " + burger.getName() + " (" + burger.getSize() + ") $" + burger.getPrice();
        summary += "\n    • " + burger.getBun() + "  +$" + String.format("%.2f", burger.getBun().getPrice()) + "\n";
        summary += "    • " + burger.getPatty() + "  +$" + String.format("%.2f", burger.getPatty().getPrice()) + "\n";

        //Create AddOn list to store items implementing Modify( meaning they can have addOns)
        List<AddOn> addOns = burger.getAddOns();

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
        if(burger.isToasted()){
            summary += "    • Consented Toasted Bun +$50.00\n";
        }else{
            summary += "    • Cold Bun\n";
        }

        summary +=  "    •Drink: " + drink.getName() + " (" + drink.getSize() + ")\n";
        summary += "    •Side: " + side.getName() + " (" + side.getSize() + ")\n";
        summary+= "===============================\n";
        summary +=  String.format("   Combo Price: $%.2f", calculatePrice());

        return summary;
    }

    //Getters
    public KrabbyChumPatty getBurger() {
        return burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public Side getSide() {
        return side;
    }

    //String for us to display Combo info to order
    public String comboInfo(){
        String summary = getName() + "\n";
        summary += "   - Burger: " + burger.getName() + " (" + burger.getSize() + ") $" + burger.getPrice();
        summary += "\n    • " + burger.getBun() + "  +$" + String.format("%.2f", burger.getBun().getPrice()) + "\n";
        summary += "    • " + burger.getPatty() + "  +$" + String.format("%.2f", burger.getPatty().getPrice()) + "\n";

        //Create AddOn list to store items implementing Modify( meaning they can have addOns)
        List<AddOn> addOns = burger.getAddOns();

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
        if(burger.isToasted()){
            summary += "    • Consented Toasted Bun +$50.00\n";
        }else{
            summary += "    • Cold Bun\n";
        }

        summary +=  "    •Drink: " + drink.getName() + " (" + drink.getSize() + ")\n";
        summary += "    •Side: " + side.getName() + " (" + side.getSize() + ")\n";

        return summary;
    }
}
