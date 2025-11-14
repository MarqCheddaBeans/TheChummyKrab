package com.pluralsight.models;

import com.pluralsight.models.combos.SignatureBurger;
import com.pluralsight.models.combos.SignatureComboMeal;
import com.pluralsight.models.combos.SignatureDrink;
import com.pluralsight.models.combos.SignatureSide;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.models.combos.SignatureBurger.SignatureAddOn.*;
import static com.pluralsight.models.combos.SignatureBurger.SignatureBun.*;
import static com.pluralsight.models.combos.SignatureBurger.SignaturePatty.*;
import static com.pluralsight.models.Size.*;

//This is our Menu
public class Menu {

    //AddOns available for user
    public static List<AddOn> getDaAddons(){

        List<AddOn> addOns = new ArrayList<>();
        addOns.add(new AddOn("Single Krusty Red Round",.25,false));
        addOns.add(new AddOn("Krunchy Kelp",.25,false));
        addOns.add(new AddOn("Half a Chumion",.25,false));
        addOns.add(new AddOn("Peppers",.25,false));
        addOns.add(new AddOn("Ketchup",.25,false));
        addOns.add(new AddOn("Mayo",.25,false));
        addOns.add(new AddOn("Super Secret Sauce",1.50,true));
        addOns.add(new AddOn("Jellyfish Jelly",1.00,true));
        addOns.add(new AddOn("Sea Pickle Chip",.25,false));
        addOns.add(new AddOn("Cheese",1.00,true));
        addOns.add(new AddOn("Extra Patty",2.00,true));

        return addOns;
    }

    //Drinks available for user
    public static List<Drink> getDaDrinks(){

        List<Drink> drinks = new ArrayList<>();

        drinks.add(new Drink("Diet DrKelp", MEDIUM));
        drinks.add(new Drink("Kelp Juice", MEDIUM));
        drinks.add(new Drink("Juggernog", MEDIUM));
        drinks.add(new Drink("Kelp Shake", MEDIUM));
        drinks.add(new Drink("Sea Water", MEDIUM));
        drinks.add(new Drink("Speed Cola", MEDIUM));

        return drinks;
    }

    //Sides available for user
    public static List<Side> getDaSides(){

        List<Side> sides = new ArrayList<>();
        sides.add(new Side("Crispity Crunchities", MEDIUM));
        sides.add(new Side("Chum Stick", MEDIUM));
        sides.add(new Side("Kelp Fries", MEDIUM));
        sides.add(new Side("Chum Fries", MEDIUM));
        sides.add(new Side("Coral nuggets", MEDIUM));
        return sides;
    }

    public static List<KrabbyChumPatty> getDaBurgers(){

        List<KrabbyChumPatty> burger = new ArrayList<>();
        burger.add(new KrabbyChumPatty(2.00,SMALL));
        burger.add(new KrabbyChumPatty(3.75,MEDIUM));
        burger.add(new KrabbyChumPatty(4.25,LARGE));

        return burger;
    }

    public static List<SignatureComboMeal> getSigMeals(){

        List<SignatureComboMeal> meals = new ArrayList<>();

        //Signature Pretty Patty creation
        SignatureBurger prettyPatty = new SignatureBurger("The Pretty Patty",PRETTYB, PRETTYP);
        prettyPatty.addAddOn(PKELP);
        prettyPatty.addAddOn(PONION);
        prettyPatty.addAddOn(PPICKLE);
        prettyPatty.addAddOn(PTOMATO);
        prettyPatty.addAddOn(PCHEESE);
        SignatureDrink prettyDrink = new SignatureDrink("Pretty Kelp Shake");
        SignatureSide prettySide = new SignatureSide("Pretty Fries");

        //Signature NastyPatty creation
        SignatureBurger nastyPatty = new SignatureBurger("The Nasty Patty",NASTYB, NASTYP);
        nastyPatty.addAddOn(VOLCSAUCE);
        nastyPatty.addAddOn(OLDKETCH);
        nastyPatty.addAddOn(TOECLIP);
        nastyPatty.addAddOn(SOCK);
        nastyPatty.addAddOn(RADISH);
        SignatureDrink nastyDrink = new SignatureDrink("Fresh bottle Of Quick Revive");
        SignatureSide nastySide = new SignatureSide("ChumStick from like 3 years ago");

        SignatureComboMeal pretty = new SignatureComboMeal("Pretty Patty Combo", 30.00 ,prettyPatty,prettyDrink,prettySide);
        SignatureComboMeal nasty = new SignatureComboMeal("Nasty Patty Combo", 26.50, nastyPatty, nastyDrink,nastySide);

        meals.add(pretty);
        meals.add(nasty);

        return meals;

    }

}
