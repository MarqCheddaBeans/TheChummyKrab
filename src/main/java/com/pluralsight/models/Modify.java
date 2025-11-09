package com.pluralsight.models;

import java.util.List;

//For items with addons
public interface Modify {

    //Need to be able to add, remove, and get AddOns
    void addAddOn(AddOn a);

    void removeAddOn(AddOn a);

    List<AddOn> getAddOns();

    BunType getBun();

    PattyType getPatty();

    boolean isToasted();
}
