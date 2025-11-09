package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.models.Menu.*;
import static com.pluralsight.models.Size.*;
import static com.pluralsight.ui.Helper.*;
import static com.pluralsight.ui.Prompts.*;

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

       while(true) {
           System.out.println("=========================");
           System.out.println("       TheChummyKrab     ");
           System.out.println("=========================");

           System.out.println("Welcome!");
           System.out.println("1) New Order");
           System.out.println("0) Exit");

           int menuChoice = getValidNumInput();

           switch (menuChoice) {
               case 1:
                   orderMenu();
                   break;
               case 0:
                   System.out.println("Goodbye");
                   System.exit(0);
               default:
                   System.out.println("Invalid input, try again");
           }
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

           int input = getValidNumInput();

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
       System.out.println("\nBuild Your 'Burger'");

       //Prompt for size then display

       int choice = -1;
       while(true){
           System.out.println("\nPlease choose a size:");

           for(int i = 0; i < burgers.size(); i++){
               System.out.println((i+1) + ") " + burgers.get(i).getName() + " $" + burgers.get(i).getPrice());
           }

           choice = getValidNumInput();
           if(choice >= 1 && choice <= burgers.size()){
               break;
           }
           System.out.println("No, try again.");
       }

       //set burger to our selected size, subtracting 1 to account for index
       KrabbyChumPatty burger = burgers.get(choice - 1);

       //switch to assign size
       Size size = switch(choice){
           case 1 -> SMALL;
           case 2 -> MEDIUM;
           case 3 -> LARGE;
           default -> MEDIUM;
       };
       System.out.println("\nYou selected: " + size.getName());
       burger.setSize(size);

       //Ask user for bread type
       BunType userBun = askBunType();
       burger.setBun(userBun);

       //ask user for patty type
       PattyType userPatty = askPattyType();
       burger.setPatty(userPatty);

       //Ask user for addons
       askAddOns(burger);

       //Check if user selected a bun before demanding to toast it
       if(burger.getBun() != BunType.NONE){
           askToasted(burger);
       }

       //Confirm, redo or cancel order
       System.out.println("\n===============================");
       System.out.println("     🧾 ORDER SUMMARY 🧾");
       System.out.println("===============================");

       System.out.println(burger);
       System.out.println("===============================");

       int confirmChoice;
       while(true){
           System.out.println("Would you like to:");
           System.out.println("1) Confirm Order");
           System.out.println("2) ReDo Burger");
           System.out.println("0) Cancel Order");

               confirmChoice = getValidNumInput();

                if (confirmChoice == 1 || confirmChoice == 2 || confirmChoice == 0){
                    System.out.println("No. Try Again");
                    break;
                }
       }
       //Advanced switch to handle user input to confirm, redo , or cancel order
       switch(confirmChoice){

           case 1 -> {
               order.addItem(burger);
               System.out.println("Order confirmed! Back to main menu");
               orderMenu();
           }
           case 2 -> {
               System.out.println("ReDo your burger!");
               promptBurger();
           }
           case 0 -> {
               System.out.println("Order canceled, GET OUT!");
               orderMenu();
           }
           default -> {
               System.out.println("Error. Returning to menu.");
               homeScreen();
           }
       }
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

       int choice;
       while(true){
           choice = getValidNumInput();

           if(choice >= 1 && choice <= drinks.size()){
               break;
           }
           System.out.println("No. Try Again");
       }
       //subtract user choice by 1 for drinks index
       Drink drink = drinks.get(choice - 1);

       //prompt user for size
       System.out.println("Choose Size: 1) Small 2) Medium 3) Large");
       int sizeChoice;

       while(true){
           sizeChoice = getValidNumInput();
           if (sizeChoice >= 1 && sizeChoice <= 3){
               break;
           }
           System.out.println("No. Try again");
       }

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

       int choice;
       while(true){
           choice = getValidNumInput();

           if(choice >= 1 && choice <= sides.size()){
               break;
           }
           System.out.println("No. Try Again");
       }

       //subtract user choice by 1 for sides index
       Side side = sides.get(choice - 1);

       //prompt user for size
       System.out.println("Choose Size: 1) Small 2) Medium 3) Large");

       int sizeChoice;

       while(true){
           sizeChoice = getValidNumInput();
           if (sizeChoice >= 1 && sizeChoice <= 3){
               break;
           }
           System.out.println("No. Try again");
       }

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
       if(order.getItems().isEmpty()){
           System.out.println(order);
           homeScreen();
           return;
       }

       while(true){
           //Display order
           System.out.println(order);

           System.out.println("\nWould you like to: ");
           System.out.println("1) Edit an item");
           System.out.println("2) Remove an item");
           System.out.println("3) Confirm Order");
           System.out.println("0) Cancel and return to menu");

           int input = getValidNumInput();
       }

       //if yes create receipt and display confirmation

       //if no either restart menu or go back to edit order
   }
}
