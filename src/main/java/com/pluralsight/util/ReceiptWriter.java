package com.pluralsight.util;

import com.pluralsight.models.AddOn;
import com.pluralsight.models.MenuItem;
import com.pluralsight.models.Modify;
import com.pluralsight.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Writes to new files creating receipts
public class ReceiptWriter {

    //We need a method that will write to a new file everytime inside of a receipts folder, name the file localdatenow, make it look pretty
 public static void createReceipt(Order order){

     //Create a string holding current date and time for us to name our file
     String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));

     //Create File object so that we can write file in Receipt folder, naming the file with our created string fileName
     File file = new File("src/main/resources/receipts", fileName);

     //try with resources creating a fileWriter, writing to our created file
     try(FileWriter writer = new FileWriter(file)){

         //Write our receipt information from getReceiptInfo class and print confirmation
        writer.write(getReceiptInfo(order));
        System.out.println("Receipt saved!");

        //Handle IOException
     }catch(IOException e){
         System.out.println("You done did it");
     }
 }

 //We need to make the information on the receipt look pretty
 public static String getReceiptInfo(Order order) {

     //Create String named receipt that will be a super concatenation
     String receipt = "🦀 The Chummy Krab 🦀\n";
     receipt += "---------------------------------\n";
     receipt += "Order Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")) + "\n\n";

     //Need to create a list of MenuItems that will get our items in customers order
     List<MenuItem> items = order.getItems();

     //Check if customer ordered anything
     if (items.isEmpty()) {
         receipt += "Nothing was ordered, GET OUT!";
     } else {
         //Tried to use stream but got confused, lets loop through the items in our list
         for (MenuItem i : items) {
             //each line adding name and price of item
             receipt += "- " + i.getName() + " $" + String.format("%2f", i.calculatePrice()) + "\n";

             //Check if our item contains the Modify interface(meaning it has addons) so we can add the addons to the receipt
             if (i instanceof Modify m) {
                 //Another list, this one contains AddOns named addons, calling getAddOns method from the Modify interface
                 List<AddOn> addOns = m.getAddOns();

                 //Check if item implementing Modify even has any addons
                 if (!addOns.isEmpty()) {
                     //loop through our add ons and add a beautifl bullet point and the name of the addon
                     for (AddOn a : addOns) {
                         receipt += "    • " + a.getName();

                         //Let the customer know if the addon was premium so they dont complain about the extra pricing
                         if (a.isPremium()) {
                             receipt += " [Premium]";
                         }
                         //More concatenation to make our info format nicely
                         receipt += " +$" + String.format("%.2f", a.getPrice()) + "\n";
                     }
                     //if no addons, simply put no addons
                 } else {
                     receipt += "    • No addons\n";
                 }
             }
         }
     }

     //Display total and optional disclaimer
     receipt += "\n--------------------------------------\n";
     receipt += "Total: $" + String.format("%.2f", order.calculateTotal()) + "\n";
     receipt += "⚠️ WARNING: Consuming The Chummy Krab's delights may result in extreme happiness, sudden urges to dance like a jellyfish,\n" +
             "or an inexplicable desire to invest in chum-based stocks. 🦀💥\n" +
             "If you survive, tell your friends. If not… well, it was tasty, right? 😎\n" +
             "Thanks for risking it all with The Chummy Krab!\n";
     receipt += "--------------------------------------\n";

     //Return our receipt string so that it can be used to write to the receipt file
     return receipt;
 }
}
