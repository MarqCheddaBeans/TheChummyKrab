package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.models.Menu.getDaAddons;
import static com.pluralsight.ui.Helper.getValidNumInput;
import static com.pluralsight.ui.Helper.getValidStrInput;

//This class will mainly handle prompts for building our burger
public class Prompts {

    //classwide scanner
    public static Scanner scan = new Scanner(System.in);

    //method to prompt user for bun type
    public static BunType askBunType() {
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

            if(scan.hasNextInt()){
                int pattyInput = scan.nextInt();
                scan.nextLine();

                //check if user input is valid(prevent out of bound exception i think)
                if(pattyInput > 0 && pattyInput <= buns.length){
                    //subtract 1 from input for proper index and print confirmation
                    userBun = buns[pattyInput - 1];
                    System.out.println("You added: " + userBun.getDisplayName() + " $" + userBun.getPrice());
                    //exit loop because user provided proper input
                    break;
                } else{
                    System.out.println("Invalid choice");
                }

            } else {
                //handle invalid input
                String invalid = scan.nextLine();
                System.out.println("What is | " + invalid + " | ?? TRY AGAIN");
            }
        }
        //give back userBun
        return userBun;
    }

    //method to prompt user for patty type
    public static PattyType askPattyType() {

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

            if(scan.hasNextInt()){
                int pattyInput = scan.nextInt();
                scan.nextLine();

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

            }else{
                System.out.println("No, Try again.");
                scan.nextLine();
            }
        }
        //give back users patty
        return userPatty;
    }

    //method to prompt user for addons
    public static KrabbyChumPatty askAddOns( KrabbyChumPatty burger) {
        System.out.println("\nSelect AddOns:");

        while(true){
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
            System.out.println("\nPlease make a selection");

            int inputAddOn = getValidNumInput();

                //Single lined if statement
                if(inputAddOn == 0) {
                    System.out.println("\nAll toppings added successfully");
                    break;
                }

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

    //Method to prompt user for toasted bun option
    public static void askToasted(KrabbyChumPatty burger) {

        //default toasted to false until we can confirm true
        boolean toasted = false;

        //trap user in loop until they satisfy requirements
        while(true){
            System.out.println("\nWould you like your bun toasted? (y/n): ");
            String toastedInput = getValidStrInput();

            if(toastedInput.equalsIgnoreCase("y")){
                toasted = true;
                System.out.println("TOASTED BUN = $50 NO REFUNDS");
                break;
            }else if(toastedInput.equalsIgnoreCase("n")){
                System.out.println("No toasted bun?? Are you sure? (y/n)");
                String validToast = scan.nextLine();

                if (validToast.equalsIgnoreCase("y")){
                    System.out.println("Thats crazy, enjoy your cold buns");
                    break;
                }else if(validToast.equalsIgnoreCase("n")){
                    System.out.println("Excellent choice!\nTOASTED BUN = $50 NO REFUNDS");
                    toasted = true;
                    break;
                }else{
                    System.out.println("Invalid input. Try again");
                }
            }else{
                System.out.println("You gotta enter 'y' or 'n'");
            }
        }
        //set toasted to boolean user choice
        burger.setToasted(toasted);
    }



}
