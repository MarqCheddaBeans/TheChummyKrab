package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.models.Size.*;

public class Menu {

    public static List<AddOn> getDaAddons(){

        List<AddOn> addOns = new ArrayList<>();
        addOns.add(new AddOn("Single Krusty Red Round",.25,false));
        addOns.add(new AddOn("Krunchy Kelp",25,false));
        addOns.add(new AddOn("Half a Chumion",.50,false));
        addOns.add(new AddOn("Super Secret Sauce",2.50,true));
        addOns.add(new AddOn("Jellyfish Jelly",2,true));
        addOns.add(new AddOn("Sea Pickle Chip",.25,false));

        return addOns;
    }

    public static List<Drink> getDaDrinks(){

        List<Drink> drinks = new ArrayList<>();

        drinks.add(new Drink("Diet DrKelp", 2, MEDIUM));
        drinks.add(new Drink("Kelp Juice", 3, MEDIUM));
        drinks.add(new Drink("Kelp Shake", 4, MEDIUM));
        drinks.add(new Drink("Sea Water",1, MEDIUM));

        return drinks;
    }

    public static List<Side> getDaSides(){

        List<Side> sides = new ArrayList<>();
        sides.add(new Side("Crispity Crunchities", 3.49, MEDIUM));
        sides.add(new Side("Chum Stick", 2.99, MEDIUM));
        sides.add(new Side("Kelp Fries", 2.49, MEDIUM));
        sides.add(new Side("Chum Fries", 2.49, MEDIUM));
        sides.add(new Side("Coral nuggets", 5, MEDIUM));
        return sides;
    }

    public static List<KrabbyChumPatty> getDaBurgers(){

        List<KrabbyChumPatty> burger = new ArrayList<>();
        burger.add(new KrabbyChumPatty(1,SMALL));
        burger.add(new KrabbyChumPatty(1.5,MEDIUM));
        burger.add(new KrabbyChumPatty(2,LARGE));

        return burger;
    }


}
