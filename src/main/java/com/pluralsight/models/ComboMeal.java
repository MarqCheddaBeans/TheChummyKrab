package com.pluralsight.models;

//class to represent our combo meal object, will deal with menu items
public class ComboMeal extends MenuItem{

    private KrabbyChumPatty burger;
    private Drink drink;
    private Side side;

    public ComboMeal(KrabbyChumPatty burger, Drink drink, Side side){
        super("Combo Meal");
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    @Override
    public double calculatePrice(){

        double total = 0;

        if(burger != null) total += burger.calculatePrice();
        if(drink != null) total += drink.calculatePrice();
        if(side != null) total += side.calculatePrice();

        this.price = total;
        return total;
    }

    @Override
    public String getName(){
        return burger.getName() + " Combo";
    }

    @Override
    public String toString() {
        return  getName() + "\n" +
                "   - Burger: " + burger.getName() + " (" + burger.getSize() + ")\n" +
                "   - Drink: " + drink.getName() + " (" + drink.getSize() + ")\n" +
                "   - Side: " + side.getName() + " (" + side.getSize() + ")\n"+
                String.format("   Combo Price: $%.2f", calculatePrice());
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
}
