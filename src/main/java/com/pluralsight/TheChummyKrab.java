package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.ui.UserInterface;
import com.pluralsight.util.ReceiptWriter;

import java.sql.SQLOutput;

import static com.pluralsight.models.Menu.getDaAddons;
import static com.pluralsight.models.Menu.getDaBurgers;
import static com.pluralsight.models.Size.SMALL;
import static com.pluralsight.models.Size.MEDIUM;
import static com.pluralsight.models.Size.LARGE;
import static com.pluralsight.util.ReceiptWriter.createReceipt;


//Where the magic happens
public class TheChummyKrab {

    public static void main(String[] args) {

        //Instantiate UI
        UserInterface ui = new UserInterface();

        //Call display method
        ui.display();

        //AddOn addOn = getDaAddons().get(4);

        //burger.addAddOn(addOn);

//        AddOn tomato = new AddOn("Tomato",1,false);
//        AddOn lettuce = new AddOn("lettuce",1,false);
//        AddOn onion = new AddOn("Onion",1,false);
//        AddOn special = new AddOn("Secret Sauce",2.50,true);
//        AddOn jelly = new AddOn("Jellyfish Jelly",3,true);
//
//        KrabbyChumPatty small = new KrabbyChumPatty(4, SMALL);
//        small.addAddOn(tomato);
//        small.addAddOn(lettuce);
//        small.addAddOn(jelly);
//        small.addAddOn(tomato);
//        KrabbyChumPatty medium = new KrabbyChumPatty(4, MEDIUM);
//        medium.addAddOn(jelly);
//        medium.addAddOn(special);
//        medium.addAddOn(onion);
//        medium.addAddOn(tomato);
//        KrabbyChumPatty large = new KrabbyChumPatty(4, LARGE);
//        large.addAddOn(jelly);
//        large.addAddOn(onion);
//        large.addAddOn(special);
//        large.addAddOn(tomato);
//        KrabbyChumPatty otherL = new KrabbyChumPatty(4, LARGE);
//
//        Order order = new Order();
//        order.addItem(small);
//        order.addItem(medium);
//        order.addItem(large);
//        order.addItem(otherL);
//
//        Drink kelpShake = new Drink("Kelp Shake",2, SMALL);
//        Drink myDrink = new Drink("Diet DrKelp",2, MEDIUM);
//        Drink myOtherDrink = new Drink("Kelp Juice",2, LARGE);
//        order.addItem(kelpShake);
//        order.addItem(myDrink);
//        order.addItem(myOtherDrink);
//
//        Side kFries = new Side("Kelp Fries", 3 , SMALL);
//        Side cC = new Side("Crispity Crunchities", 3.75, MEDIUM);
//        Side cS = new Side("Chum Stick", 2,LARGE);
//        order.addItem(kFries);
//        order.addItem(cC);
//        order.addItem(cS);
//
//        System.out.println(order);
//
//        ReceiptWriter receipt = new ReceiptWriter();
//        createReceipt(order);

    }
}
