package com.pluralsight.models;

//Enumeration (Enum) used to represent group of named constants(ex day of week Mon-Sun will never change)
public enum Size {

    //Enum constants for our sizes, will multiply price based on size, hold name for our "Burgers"

    //Small will keep base price and give the small burger a name
    SMALL(1.0, "Chummy Patty Jr."),

    //Medium will multiply base price by 1.875 and give medium size burger name
    MEDIUM(1.875,"Chummy Patty"),

    //Large will multiple base price a whopping 2.25x and give large size burger beautiful name
    LARGE (2.25, "King Neptune's Chummy Patty");

    //We need to set a multiplier and name for each size, name will only be for pattys
    private final double multiplier;
    private final String name;

    //Create constructor so Enum class stops yelling at me
    Size(double multiplier, String name){
        this.multiplier = multiplier;
        this.name = name;
    }

    //Overload constructor so the drinks and side arent named per size
    Size(double multiplier){
        this.multiplier = multiplier;
        this.name = null;
    }

    //Gotta get them getters
    public double getMultiplier(){
        return multiplier;
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
