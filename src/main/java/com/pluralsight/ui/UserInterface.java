package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.models.Menu.*;
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
       System.out.println("\nBuild Your 'Burger'");

       //Prompt for size
       System.out.println("\nPlease choose a size:");

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

       //Ask user for toasted bun

       System.out.println("\nWould you like your bun toasted? (y/n): ");
       String toastedInput = scan.nextLine().toLowerCase();

       if(toastedInput.equalsIgnoreCase("y")){
           burger.setToasted(true);
           System.out.println("TOASTED BUN = $50 NO REFUNDS");
       }else {
           System.out.println("No toasted bun?? Are you sure? (y/n)");
           String validToast = scan.nextLine();
           if (validToast.equalsIgnoreCase("y")){
               System.out.println("Thats crazy, enjoy your cold buns");
           }else{
               System.out.println("Excellent choice\nTOASTED BUN = $50 NO REFUNDS");
               burger.setToasted(true);
           }
           burger.setToasted(false);
       }

   }

    private KrabbyChumPatty askAddOns( KrabbyChumPatty burger) {
        System.out.println("\nSelect AddOns:");

        System.out.println("\n--- REGULAR ADDONS ---");

        //Store regular addons in a list using beautiful stream
        List<AddOn> regular = getDaAddons().stream()
                .filter(r -> !r.isPremium())
                .toList();

        //cycle through our list of regular addons and print them out
        for(int i = 0; i < regular.size(); i++){
            AddOn a = regular.get(i);
            System.out.println((i+1) + ") " + a.getName() + " $0.25");
        }

        // same thing we did with regular addons do with premium addons
        System.out.println("\n--- PREMIUM ADDONS ---");
        List<AddOn> premium = getDaAddons().stream()
                .filter(p -> p.isPremium())
                .toList();

        for(int i = 0; i<premium.size(); i++){
            AddOn a = premium.get(i);
            System.out.println((i + 1 + regular.size()) + ") " + a.getName() + " [+$" + a.getPrice() + "]");
        }

        System.out.println("0) Done");

        //loop for user input
        while(true){

            //prompt user to pick an addon
            System.out.println("\nPlease make a selection");
            int inputAddOn = scan.nextInt();

            //Single lined if statement
            if(inputAddOn == 0) break;

            //calc number of total addons
            int totalAddOns = regular.size() + premium.size();

            //input validaiton
            if(inputAddOn > 0 && inputAddOn<= totalAddOns){
                AddOn chosen;

                //check if user input is within range of regular addons
                if (inputAddOn <= regular.size()){
                    chosen = regular.get(inputAddOn - 1);

                    //if not, it is a premium topping, subtract by 1 to account for index
                } else{
                    chosen = premium.get(inputAddOn - regular.size() - 1);
                }

                //Add the chosen addon to burger and print confirmation
                burger.addAddOn(chosen);
                System.out.println("\nAdded: " + chosen.getName() + " $" + chosen.getPrice());
            } else {
                //invalid input
                System.out.println("Invalid choice, try again");
            }
        }
        return burger;
    }

    public BunType askBunType() {
        System.out.println("\nChoose Your Bun");

        //throw our buns into an array
        BunType[] buns = BunType.values();

        //display buns with price
        for (int i = 0; i < buns.length; i++){
            System.out.println((i+1) + ") " + buns[i] + " +$" +buns[i].getPrice());
        }

        //Create bun that will be used to set our burgers bun
        BunType userBun;

        //Force user to give valid input
        while(true){
            System.out.println("Enter your choice");
            int pattyInput = scan.nextInt();

            //check if user input is valid(prevent out of bound exception i think)
            if(pattyInput > 0 && pattyInput <= buns.length){
                //subtract 1 from input for proper index and print confirmation
                userBun = buns[pattyInput - 1];
                System.out.println("You added: " + userBun.getDisplayName() + " - $" + userBun.getPrice());
                //exit loop because user provided proper input
                break;
            } else{
                System.out.println("Invalid choice");
            }
        }
        //give back userBun
        return userBun;
    }

    public PattyType askPattyType() {

        System.out.println("\nChoose Your Patty");

        //throw our patties into an array
        PattyType[] patties = PattyType.values();

        //display patties with price
        for (int i = 0; i < patties.length; i++){
            System.out.println((i+1) + ") " + patties[i] + " +$" +patties[i].getPrice());
        }

        //Create patty object that will be users chosen patty
        PattyType userPatty;

        //trap user in forever loop until they give me valid input
        while(true){
            System.out.println("Enter your choice");
            int pattyInput = scan.nextInt();

            //prevent ArrayOOBException i think
            if(pattyInput > 0 && pattyInput <= patties.length){
                //account for index
                userPatty = patties[pattyInput - 1];
                System.out.println("You added: " + userPatty.getDisplayName() + " - $" + userPatty.getPrice());
                //exit loop
                break;
            } else{
                System.out.println("Invalid choice");
            }
        }
        //give back users patty
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
