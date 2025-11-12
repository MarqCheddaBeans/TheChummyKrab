package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.models.Menu.*;
import static com.pluralsight.models.Size.*;
import static com.pluralsight.ui.Helper.*;
import static com.pluralsight.ui.Prompts.*;
import static com.pluralsight.util.ReceiptWriter.createReceipt;

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
   public void homeScreen() {

       //clear order when user returns to home screen
       order = new Order();

       while (true) {
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
           System.out.println("4) Signature Menu");
           System.out.println("5) Checkout");
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
                   sigMenu();
               case 5:
                   checkout();
                   break;
               case 0:
                   System.out.println("Order Canceled");
                   homeScreen();
                   return;
               default:
                   System.out.println("Invalid choice");
                   break;
           }
       }
   }

   public void sigMenu(){

       System.out.println("=========================");
       System.out.println("       Signature Menu       ");
       System.out.println("=========================");

       System.out.println("\nWhich signature meal would you like?");

       for(int i = 0; i<getSigMeals().size(); i++){
           System.out.println((i+1) + ") " + getSigMeals().get(i).getName());
       }
       System.out.println("3) Go back");

       int input = getValidNumInput();

       switch(input){
           case 1 -> {
               SignatureComboMeal prettyPatty = promptPrettyPatty();
               if(!prettyPatty.equals(null)){
                   order.addItem(prettyPatty);
               }
               orderMenu();
               break;
           }
           case 2 ->{
               SignatureComboMeal nastyPatty = promptNastyPatty();
               if(!nastyPatty.equals(null)){
                   order.addItem(nastyPatty);
               }
               orderMenu();
           }
           case 3 -> {
               orderMenu();
           }
           default -> {
               System.out.println("Invalid input");
               break;
           }

       }

   }

   //prompts pretty patty selection
    public SignatureComboMeal promptPrettyPatty(){

        System.out.println(getSigMeals().get(0));

        System.out.println("1) Confirm meal");
        System.out.println("2) Cancel meal");

        int input = getValidNumInput();

        if(input == 1){
            return getSigMeals().get(0);
        } else{
            System.out.println("Meal Cancelled");
            return null;
        }
    }

    public SignatureComboMeal promptNastyPatty(){

        System.out.println(getSigMeals().get(1));

        System.out.println("1) Confirm meal");
        System.out.println("2) Cancel meal");

        int input = getValidNumInput();

        if(input == 1){
            return getSigMeals().get(1);
        } else{
            System.out.println("Meal Cancelled");
            return null;
        }
    }
   //Ask for burger specs
   public void promptBurger(){

       //init burgers
       List<KrabbyChumPatty> burgers = getDaBurgers();

       //Header
       System.out.println("\n=========================\n");
       System.out.println("\tBuild Your 'Burger'");
       System.out.println("\n=========================\n");



       //Prompt for size then display

       int choice = -1;
       while(true){
           System.out.println("\nPlease choose a size:");

           for(int i = 0; i < burgers.size(); i++){
               System.out.println((i+1) + ") " + burgers.get(i).getName() + " $" + burgers.get(i).getPrice() + " (" + burgers.get(i).getSize() + ")");
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

       //Prompt Combo
       ComboMeal combo = null;

       while(true){
           System.out.println("\nWould you like to make " + burger.getName() + " a combo?(Y/N)");
           String comInput = getValidStrInput();

           if(comInput.equalsIgnoreCase("y")){
               combo = promptCombo(burger);
               break;
           } else if(comInput.equalsIgnoreCase("n")){
               break;
           } else{
               System.out.println("Invalid input, Y or N");
           }
       }


       //Confirm, redo or cancel order
       System.out.println("\n===============================");
       System.out.println("     🧾 ORDER SUMMARY 🧾");
       System.out.println("===============================");

       if(combo != null){
           System.out.println(combo);
       } else{
           System.out.println(burger);
       }
       System.out.println("===============================");

       int confirmChoice;
       while(true){
           System.out.println("\nWould you like to:");
           System.out.println("1) Confirm order");
           System.out.println("2) Redo order");
           System.out.println("0) Cancel order");

               confirmChoice = getValidNumInput();

               if(confirmChoice == 1 || confirmChoice == 2 || confirmChoice == 0){
                   break;
               }
       }
       //Advanced switch to handle user input to confirm, redo , or cancel order
       switch(confirmChoice){

           case 1 -> {
               order.addItem(combo);
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
       System.out.println("\n=========================\n");
       System.out.println("\tAdd Drink");
       System.out.println("\n=========================\n");
       //Prompt use to choose drink
       System.out.println("Choose a drink: \n");

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
       System.out.println("\nChoose Size: 1) Small 2) Medium 3) Large");
       int sizeChoice;

       while(true){
           sizeChoice = getValidNumInput();
           if (sizeChoice >= 1 && sizeChoice <= 3){
               break;
           }
           System.out.println("No. Try again\n");
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

       System.out.println(drink.getSize() + " " + drink.getName() + " added to order!\n");
   }

   //prompt for side specs same as drink
   public void promptSide(){

       //List to init sides
       List<Side> sides = getDaSides();

       //Header
       System.out.println("\n=========================\n");
       System.out.println("\tAdd a side");
       System.out.println("\n=========================\n");

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
       System.out.println("\nChoose Size: 1) Small 2) Medium 3) Large");

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
           System.out.println("0) Cancel and return to order menu");

           int input = getValidNumInput();

           switch (input){
               case 1 -> {
                   editOrderItem();
                   checkout();
               }
               case 2 -> {
                   removeOrderItem();
                   checkout();
               }
               case 3 -> {
                   createReceipt(order);
                   homeScreen();
               }
               case 0 ->{
                   System.out.println("Returning to order menu");
                   orderMenu();
               }
               default -> System.out.println("Invalid input. try again");
           }
       }
   }

   public void editOrderItem(){
       List<MenuItem> items = order.getItems();

       //check if any items were added to the order
       if(items.isEmpty()) {
           System.out.println("No items to edit");
           checkout();
       }

       System.out.println("Which item would you like to edit?");

       //cycle through items
       for(int i = 0; i < items.size(); i++){
           //signature combos cannot be edited
           if(items.get(i) instanceof SignatureComboMeal){
               System.out.println();
               continue;
           }
           //everything else will be displayed to user
           System.out.printf("%d) %s - $%.2f%n", (i+1), items.get(i).getName(), items.get(i).getPrice());
       }
       System.out.println("\n0) Cancel");

       int input;
       while(true){

           System.out.print( "Enter choice: ");
           input = getValidNumInput();

           if(input == 0){
               checkout();
               return;
           }

           if (input >= 1 && input <= items.size()) {
               break;
           }
           System.out.println("Invalid input. try again");
       }

       MenuItem selected = items.get(input - 1);
       System.out.println("\nYou selected: " + selected.getName());

       if(selected instanceof KrabbyChumPatty k){
           System.out.println("Lets edit your burger...");
           order.removeItem(selected);
           promptBurger();
       } else if( selected instanceof Drink d){
           System.out.println("Lets switch out your " + d.getName());
           order.removeItem(selected);
           promptDrink();
       } else if(selected instanceof Side s){
           System.out.println(s.getName() + " isnt good anyway, lets edit");
           order.removeItem(selected);
           promptSide();
       } else if(selected instanceof ComboMeal c){
           System.out.println("You didnt like the combo?");
           order.removeItem(selected);
           promptBurger();
       }else{
           System.out.println("Not sure what youre looking for. Returning to checkout.");
           checkout();
       }
   }

   public void removeOrderItem(){
       List<MenuItem> items = order.getItems();

       if(items.isEmpty()){
           System.out.println("No items to remove");
           checkout();
           return;
       }

       System.out.println("Which item would you like to remove?");

       for(int i = 0; i < items.size(); i++){
           System.out.printf("%d) %s - $%.2f%n", (i+1), items.get(i).getName(), items.get(i).calculatePrice());
       }
       System.out.println("0) Cancel");

       int input;
       while(true){

           System.out.print( "Enter choice: ");
           input = getValidNumInput();

           if(input == 0){
               checkout();
               return;
           }

           if (input >= 1 && input <= items.size()) {
               break;
           }
           System.out.println("Invalid input. try again");
       }

       MenuItem selected = items.get(input - 1);
       System.out.println("\nYou selected: " + selected.getName());

       if(selected instanceof KrabbyChumPatty k){
           System.out.println("Lets remove your burger...");
           order.removeItem(selected);
           checkout();
       } else if( selected instanceof Drink d){
           System.out.println("Lets remove out your " + d.getName());
           order.removeItem(selected);
           checkout();
       } else if(selected instanceof Side s){
           System.out.println(s.getName() + " isnt good anyway, lets remove");
           order.removeItem(selected);
           checkout();
       } else if(selected instanceof SignatureComboMeal s){
           System.out.println("No way!" + s.getName());
           order.removeItem(selected);
           checkout();
       }else{
           System.out.println("Not sure what youre looking for. Returning to checkout.");
           checkout();
       }
   }

   public ComboMeal promptCombo(KrabbyChumPatty burger){

            List<Drink> drinks = getDaDrinks();
            List<Side> sides = getDaSides();

           ComboMeal combo = null;

               System.out.println("Select a drink for your combo");
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

               System.out.println("Select a side for your combo");

               //Cycle through our list of sides and display to user
               for(int i = 0; i < sides.size(); i++){
                   System.out.println((i + 1) + ") " + sides.get(i).getName());
               }

               int sideInput;
               while(true){
                   sideInput = getValidNumInput();

                   if(sideInput >= 1 && sideInput <= sides.size()){
                       break;
                   }
                   System.out.println("No. Try Again");
               }

               //subtract user choice by 1 for sides index
               Side side = sides.get(sideInput - 1);

               combo = new ComboMeal(burger,drink,side);

               System.out.println(burger.getName() + " combo added to order!");

           return combo;
   }
}
