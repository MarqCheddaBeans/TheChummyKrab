package com.pluralsight.models.combos;

import com.pluralsight.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SignatureBurger extends MenuItem {

    private SignatureBun bun;
    private SignaturePatty patty;
    private List<SignatureAddOn> sigAddOns;

    public SignatureBurger(String name, SignatureBun bun, SignaturePatty patty) {
        super(name);
        this.bun = bun;
        this.patty = patty;
        this.sigAddOns = new ArrayList<>();
    }

    @Override
    public double calculatePrice(){
        return this.price;
    }

    public void addAddOn(SignatureAddOn a){
        sigAddOns.add(a);
    }

    @Override
    public String toString(){
        String info = "Burger: ";
        info += "\n\t" + getName() + "\n";
        info += "\t   • " + bun.getDisplayName() + "\n";
        info += "\t   • " + patty.getDisplayName() + "\n";
        if (!sigAddOns.isEmpty()) {
            for (SignatureAddOn s : sigAddOns) {
                info += "\t   • " + s.getDisplayName() + "\n";
            }
        }
        return info;
    }

    //Nested enums for cleanliness

    public enum SignatureBun{
        PRETTYB("Pretty Bun"),
        NASTYB("Moldy Bun"),
        CHUMB("Chum Bun");

        private final String displayName;

        SignatureBun(String displayName){
            this.displayName = displayName;
        }

        public String getDisplayName(){
            return displayName;
        }
    }

    public enum SignaturePatty{
        PRETTYP("Pretty Patty"),
        NASTYP("Old Patty"),
        CHUMP("Chum Filled Patty");

        private final String displayName;

        SignaturePatty(String displayName){
            this.displayName = displayName;
        }

        public String getDisplayName(){
            return displayName;
        }
    }

    public enum SignatureAddOn{
        VOLCSAUCE("Volcano Sauce"),
        OLDKETCH("Old Ketchup"),
        TOECLIP("Toenail Clippings"),
        SOCK("Old Gym Sock"),
        RADISH("Seahorse Radish"),
        PTOMATO("Pretty Krusty Red Round"),
        PKELP("Pretty Kelp"),
        PONION("Pretty Chumion"),
        PPICKLE("Pretty Pickle Chip"),
        PCHEESE("Pretty Cheese");

        private final String displayName;

        SignatureAddOn(String displayName){
            this.displayName = displayName;
        }

        public String getDisplayName(){
            return displayName;
        }

    }
}
