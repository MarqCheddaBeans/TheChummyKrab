package com.pluralsight.ui;

import java.io.Console;
import java.util.Scanner;

public class UserInterface {

   public Scanner scan = new Scanner(System.in);

   public UserInterface(){};

   public void display(){

       homeScreen();
   }
   public void homeScreen(){

       System.out.println("=========================");
       System.out.println("       TheChummyKrab     ");
       System.out.println("=========================");

       System.out.println("Welcome");
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
           case 1: promptBurger();
           case 2: promptDrink();
           case 3: promptSide();
           case 4: checkout();
           case 0:
               System.out.println("Order Canceled"); break;
       }
   }

   public void promptBurger(){

   }

   public void promptDrink(){

   }

   public void promptSide(){

   }

   public void checkout(){

   }
}
