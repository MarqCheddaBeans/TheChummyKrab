package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.models.BunType.*;
import static com.pluralsight.models.Menu.*;
import static com.pluralsight.models.PattyType.KELP;
import static com.pluralsight.models.Size.*;

//Handles User interactions
public class UserInterface {

    //We need the scanner
   public Scanner scan = new Scanner(System.in);

   private Order order = new Order();
   //empty constructor
   public UserInterface(){};

   //Display method to run the app
   public void display(){

       homeScreen();
   }

    //Home screen
   public void homeScreen(){

       System.out.println("=========================");
       System.out.println("       TheChummyKrab     ");
       System.out.println("=========================");

       System.out.println("Welcome!");
       System.out.println("1) New Order");
       System.out.println("0) Exit");

       int menuChoice = scan.nextInt();

       switch(menuChoice){
           case 1: orderMenu(); break;
           case 0: System.exit(0);
           default:
               System.out.println("Invalid input, try again");

       }
   }

   //Next screen, order menu
   public void orderMenu(){
       while(true) {
           System.out.println("=========================");
           System.out.println("       Place Order       ");
           System.out.println("=========================");

           System.out.println("1) Add Burger");
           System.out.println("2) Add Drink");
           System.out.println("3) Add Side");
           System.out.println("4) Checkout");
           System.out.println("0) Cancel Order");

           int input = scan.nextInt();

           switch (input) {
               case 1:
                   promptBurger();
                   break;
               case 2:
                   promptDrink();
                   break;
               case 3:
                   promptSide();
                   break;
               case 4:
                   checkout();
                   break;
               case 0:
                   System.out.println("Order Canceled");
                   return;
               default:
                   System.out.println("Invalid choice");
                   break;
           }
       }
   }

   //Ask for burger specs
   public void promptBurger(){

       //init burgers
       List<KrabbyChumPatty> burgers = getDaBurgers();

       //Header
       System.out.println("Build Your 'Burger'");

       //Prompt for size
       System.out.println("Please choose a size:");

       for(int i = 0; i < burgers.size(); i++){
           System.out.println((i+1) + ") " + burgers.get(i).getName() + " $" + burgers.get(i).getPrice());
       }
       int choice = scan.nextInt();

       KrabbyChumPatty burger = burgers.get(choice - 1);

       Size size = switch(choice){
           case 1 -> SMALL;
           case 2 -> MEDIUM;
           case 3 -> LARGE;
           default -> MEDIUM;
       };

       burger.setSize(size);
       System.out.println("Size saved");

       //Ask user for bread type(Wheat White Kelp)

       System.out.println("Choose Bun: 1) None 2) Kelp 3) Potato");
       int bunInput = scan.nextInt();

       BunType bun = switch(bunInput){
           case 1 -> NONE;
           case 2 -> KELPB;
           case 3 -> POTATO;
           default -> NONE;
       };
       System.out.println("Bun saved");

       burger.setBun(bun);


       //ask user for patty type
       PattyType userPatty = askPattyType();
       burger.setPatty(userPatty);

       //Ask user for addons (Tomato, lettuce, pickle, onion,
       System.out.println("AddOns:");
       //Ask user for sauce
       //Ask user for toasted bun
   }

    public PattyType askPattyType() {

        System.out.println("Choose Your Patty");

        //throw our patties into an array
        PattyType[] patties = PattyType.values();

        //display patties with price
        for (int i = 0; i < patties.length; i++){
            System.out.println((i+1) + ") " + patties[i] + " - +$" +patties[i].getPrice());
        }

        PattyType userPatty;

        while(true){
            System.out.println("Enter your choice");
            int pattyInput = scan.nextInt();

            if(pattyInput > 0 && pattyInput <= patties.length){
                userPatty = patties[pattyInput - 1];
                System.out.println("You added: " + userPatty.getDisplayName() + " - $" + userPatty.getPrice());
                break;
            } else{
                System.out.println("Invalid choice");
            }
        }
        return userPatty;
    }

    //Ask for drink specs
   public void promptDrink(){

       //Create list to init our menu drinks
    List<Drink> drinks = getDaDrinks();

       //Header
       System.out.println("Add Drink");

       //Prompt use to choose drink
       System.out.println("Choose a drink: ");

       //Cycle through our list of drinks and display to user
       for(int i = 0; i < drinks.size(); i++){
           System.out.println((i + 1) + ") " + drinks.get(i).getName());
       }

       //store users choice
       int choice = scan.nextInt();

       //subtract user choice by 1 for drinks index
       Drink drink = drinks.get(choice - 1);

       //prompt user for size
       System.out.println("Choose Size: 1) Small 2) Medium 3) Large");
       int sizeChoice = scan.nextInt();

       //modern switch expression to return size in Size size based on user input, semicolon at the end??
       Size size = switch (sizeChoice){
           case 1 -> SMALL;
           case 2 -> MEDIUM;
           case 3 -> LARGE;
           default -> MEDIUM;
       };

       //sets size to users choice and add drink to our order
       drink.setSize(size);
       order.addItem(drink);

       System.out.println(drink.getSize() + " " + drink.getName() + " added to order!");
   }

   //prompt for side specs same as drink
   public void promptSide(){

       //List to init sides
       List<Side> sides = getDaSides();

       //Header
       System.out.println("Add a side");

       //Prompt use to choose side
       System.out.println("Choose a side: ");

       //Cycle through our list of sides and display to user
       for(int i = 0; i < sides.size(); i++){
           System.out.println((i + 1) + ") " + sides.get(i).getName());
       }

       //store users choice
       int choice = scan.nextInt();

       //subtract user choice by 1 for sides index
       Side side = sides.get(choice - 1);

       //prompt user for size
       System.out.println("Choose Size: 1) Small 2) Medium 3) Large");
       int sizeChoice = scan.nextInt();

       //modern switch expression to return size in Size size based on user input, semicolon at the end??
       Size size = switch (sizeChoice){
           case 1 -> SMALL;
           case 2 -> MEDIUM;
           case 3 -> LARGE;
           default -> MEDIUM;
       };

       //sets size to users choice and add side to our order
       side.setSize(size);
       order.addItem(side);

       System.out.println(side.getSize() + " " + side.getName() + " added to order!");
   }

   //Checkout customer
   public void checkout(){

       //display order
       System.out.println(order);
       //ask user if they are sure they want to order

       //if yes create receipt and display confirmation

       //if no either restart menu or go back to edit order
   }
}
