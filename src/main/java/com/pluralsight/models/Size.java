package com.pluralsight.models;

//Enumeration (Enum) used to represent group of named constants(ex day of week Mon-Sun will never change)
public enum Size {

    //Enum constants for our sizes, will set price based on size, hold name for our questionableBurgers

    //Small will set base price to 2 and give the small burger a name
    SMALL(2.0, "Chummy Patty Jr."),

    //Medium will set base price to 3.75 and give medium size burger name
    MEDIUM(3.75,"Chummy Patty"),

    //Large will set base price to 4.25 and give large size burger beautiful name
    LARGE (4.25, "King Neptune's Chummy Patty");

    //We need to set a base price and name for each size, name will only be for pattys
    private final double base;
    private final String name;

    //Create constructor so Enum class stops yelling at me
    Size(double base, String name){
        this.base = base;
        this.name = name;
    }

    //Overload constructor so the drinks and side arent named per size
    Size(double base){
        this.base = base;
        this.name = null;
    }

    //Gotta get them getters
    public double getBase(){
        return base;
    }

    public String getName(){
        return name;
    }

    //To string to turn SIZE into Size format
    @Override
    public String toString(){
        String lowCase = name().toLowerCase();
        return Character.toUpperCase(lowCase.charAt(0)) + lowCase.substring(1);
    }

}
