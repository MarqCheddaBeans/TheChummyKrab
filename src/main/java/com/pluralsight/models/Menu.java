package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.models.BunType.PRETTY;
import static com.pluralsight.models.PattyType.PRETTYPATTY;
import static com.pluralsight.models.Size.*;

public class Menu {

    public static List<AddOn> getDaAddons(){

        List<AddOn> addOns = new ArrayList<>();
        addOns.add(new AddOn("Single Krusty Red Round",.25,false));
        addOns.add(new AddOn("Krunchy Kelp",.25,false));
        addOns.add(new AddOn("Half a Chumion",.25,false));
        addOns.add(new AddOn("Super Secret Sauce",2.50,true));
        addOns.add(new AddOn("Jellyfish Jelly",2.00,true));
        addOns.add(new AddOn("Sea Pickle Chip",.25,false));

        return addOns;
    }

    public static List<Drink> getDaDrinks(){

        List<Drink> drinks = new ArrayList<>();

        drinks.add(new Drink("Diet DrKelp", 2.00, MEDIUM));
        drinks.add(new Drink("Kelp Juice", 3.00, MEDIUM));
        drinks.add(new Drink("Kelp Shake", 4.00, MEDIUM));
        drinks.add(new Drink("Sea Water",1.00, MEDIUM));

        return drinks;
    }

    public static List<Side> getDaSides(){

        List<Side> sides = new ArrayList<>();
        sides.add(new Side("Crispity Crunchities", 3.49, MEDIUM));
        sides.add(new Side("Chum Stick", 2.99, MEDIUM));
        sides.add(new Side("Kelp Fries", 2.49, MEDIUM));
        sides.add(new Side("Chum Fries", 2.49, MEDIUM));
        sides.add(new Side("Coral nuggets", 5.00, MEDIUM));
        return sides;
    }

    public static List<KrabbyChumPatty> getDaBurgers(){

        List<KrabbyChumPatty> burger = new ArrayList<>();
        burger.add(new KrabbyChumPatty(2.00,SMALL));
        burger.add(new KrabbyChumPatty(3.50,MEDIUM));
        burger.add(new KrabbyChumPatty(4.25,LARGE));

        return burger;
    }

    public static List<Order> signatureOrder(){

        List<Order> sigOrders = new ArrayList<>();
        List<KrabbyChumPatty> sigBurger = new ArrayList<>();

        KrabbyChumPatty prettyPatty = new KrabbyChumPatty(25,"Pretty Patty");
        prettyPatty.setPatty(PRETTYPATTY);
        prettyPatty.setBun(PRETTY);
        Side prettyFries = new Side("Pretty Fries");
        Drink prettyKelpShake = new Drink("Pretty Kelp Shake");

        Order pP = new Order();
        pP.addItem(prettyPatty);
       // pP.addItem(prettyFries);
        pP.addItem(prettyKelpShake);

        sigOrders.add(pP);

        return sigOrders;
    }


}
