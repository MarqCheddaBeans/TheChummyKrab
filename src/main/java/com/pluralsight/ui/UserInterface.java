package com.pluralsight.ui;

import java.util.Scanner;

//Handles User interactions
public class UserInterface {

    //We need the scanner
   public Scanner scan = new Scanner(System.in);

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
       System.out.println("=========================");
       System.out.println("       Place Order       ");
       System.out.println("=========================");

       System.out.println("1) Add Burger");
       System.out.println("2) Add Drink");
       System.out.println("3) Add Side");
       System.out.println("4) Checkout");
       System.out.println("0) Cancel Order");

       int input = scan.nextInt();

       switch (input){
           case 1: promptBurger(); break;
           case 2: promptDrink();break;
           case 3: promptSide();break;
           case 4: checkout();break;
           case 0:
               System.out.println("Order Canceled"); break;
       }
   }

   //Ask for burger specs
   public void promptBurger(){

       //Ask user for size
       //Ask user for bread type(Wheat White Kelp)
       //Ask user for addons (Tomato, lettuce, pickle, onion,
       //Ask user for sauce
       //Ask user for toasted bun
   }

   //Ask for drink specs
   public void promptDrink(){

       //Ask user for size
       //Ask user for drink type
   }

   //Ask for side specs
   public void promptSide(){

       //Ask user for size
       //Ask user for side
   }

   //Checkout customer
   public void checkout(){

       //display order

       //ask user if they are sure they want to order

       //if yes create receipt and display confirmation

       //if no either restart menu or go back to edit order
   }
}
