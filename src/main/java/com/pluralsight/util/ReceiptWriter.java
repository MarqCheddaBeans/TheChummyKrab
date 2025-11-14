package com.pluralsight.util;

import com.pluralsight.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Writes to new files creating receipts
public class ReceiptWriter {

    //We need a method that will write to a new file everytime inside a receipts folder, name the file localdatenow, make it look pretty
 public static void createReceipt(Order order){

     //Add file to store folder path
     File folder = new File("src/main/resources/receipts");

     //Create a string holding current date and time for us to name our file
     String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH.mm.ss"));

     //Create File object so that we can write file in Receipt folder, naming the file with our created string fileName
     File file = new File(folder, fileName);

     //try with resources creating a fileWriter, writing to our created file
     try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){

         //Write our receipt information from getReceiptInfo class and print confirmation
        writer.write(order.toString());
        System.out.println("Success!");

        //Handle IOException
     }catch(IOException e){
         System.out.println("You done did it");
     }
 }
}
