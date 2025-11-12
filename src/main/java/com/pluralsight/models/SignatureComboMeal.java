package com.pluralsight.models;

//this class will represent our signature burger
public class SignatureComboMeal extends MenuItem{

    private SignatureBurger burger;
    private SignatureDrink drink;
    private SignatureSide side;

    public SignatureComboMeal(String name, double price, SignatureBurger burger, SignatureDrink drink, SignatureSide side){
        super(name);
        this.price = price;
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    @Override
    public double calculatePrice(){
        return this.price;
    }

    @Override
    public String toString() {
        String info = "\n========================================\n";
        info += "[Signature]" + getName() + "\n";
        info += "========================================\n";
        info += burger;
        info += drink;
        info += side;
        info += "------------------------------\n";
        info += "Combo Total: $" + String.format("%.2f", calculatePrice()) + "\n";
        return info;
    }

    //The Getters
    public SignatureBurger getBurger() {
        return burger;
    }

    public SignatureDrink getDrink() {
        return drink;
    }

    public SignatureSide getSide() {
        return side;
    }

}

