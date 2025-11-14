package com.pluralsight.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    UserInterface ui = new UserInterface();

    //Panel used to hold all of the UI components
    private static JFrame frame = new JFrame();

    //Frame is the main window
    private static JPanel panel = new JPanel();
    //Define swing object
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel message;

    private int attempts = 3;

    public static void getGUI(){

        //Window configuration
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panel inside our configured frame/ the window
        frame.add(panel);
        //allow manual x/y positioning
        panel.setLayout(null);

        //Add components to the panel

        JLabel header = new JLabel("\uD83E\uDD80 The Chummy Krab POS System \uD83C\uDF54");     //text label displaying header
        header.setBounds(50,-55,350,125);   //manual x,y,width,height placement
        panel.add(header);      //add label to panel so it can be displayed

        userLabel = new JLabel("User");
        userLabel.setBounds(15,25,80,25);
        panel.add(userLabel);

        //JTextField allows user to enter text
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        //Create our button for login
        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());    //Event handler
        panel.add(button);

        //label for status message
        message = new JLabel("");
        message.setBounds(10,110,300,25);   //positioned under login button
        panel.add(message);

        //Display the GUI
        frame.setVisible(true);
    }

    //Method implemented from ActionListener, runs when button clicked
    @Override
    public void actionPerformed(ActionEvent e) {

        //Login credentials
        String validUser = "Marq123";
        String validPass = "Pass123";

        //store users input
        String user = userText.getText();
        String password = new String(passwordText.getPassword());

        //check if attempts are used up
        if(attempts <= 0){
            message.setText("Too many attempts! Locked out.");
            button.setEnabled(false);    //disable login button
            return;      //stop processing
        }

        //check if login is correct
        if(user.equalsIgnoreCase(validUser) && password.equals(validPass)){
            message.setText("Login Successful!");
            frame.dispose();
            ui.display();
        } else{
            attempts--;      //adjust attempts
            message.setText("Nope, try again! Attempts left: " + attempts);

            //check if any attempts remain after wrong attempt
            if (attempts == 0){
                button.setEnabled(false);       //disable login button
                message.setText("Locked out! Restart app.");
            }
        }

    }

}
