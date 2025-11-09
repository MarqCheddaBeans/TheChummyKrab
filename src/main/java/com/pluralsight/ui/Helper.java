package com.pluralsight.ui;

import static com.pluralsight.ui.Prompts.scan;

//This class will make my life easier DRY
public class Helper {

    public static int getValidNumInput(){
        while(true){
            if(scan.hasNextInt()){
                int input = scan.nextInt();
                scan.nextLine();
                return input;
            }else{
                System.out.println("You gotta enter a valid number");
               //Toss invalid input
                scan.nextLine();
            }
        }
    }

    public static String getValidStrInput(){

        while(true){
            if(scan.hasNextLine()){
                String input = scan.nextLine();
                return input;
            }else{
                System.out.println("No bueno");
                //Toss invalid input
                scan.nextLine();
            }
        }
    }

}
