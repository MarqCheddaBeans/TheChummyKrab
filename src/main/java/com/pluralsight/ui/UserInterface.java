package com.pluralsight.ui;

import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Side;
import com.pluralsight.models.Size;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.models.Menu.getDaDrinks;
import static com.pluralsight.models.Menu.getDaSides;
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

       //Ask user for size
       //Ask user for bread type(Wheat White Kelp)
       //Ask user for addons (Tomato, lettuce, pickle, onion,
       //Ask user for sauce
       //Ask user for toasted bun
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
