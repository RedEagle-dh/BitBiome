package org.bitbiome.entities;

import java.util.ArrayList;

public class Location {

    private String name;
    private ArrayList<Mob> mobList;
    private ArrayList<Item> itemList;


    public Location(String name, ArrayList<Mob> mobList, ArrayList<Item> itemList) {
        this.name = name;
        this.mobList = mobList;
        this.itemList = itemList;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Mob> getMobList() {
        return mobList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }



}
