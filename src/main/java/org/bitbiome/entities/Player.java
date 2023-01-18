package org.bitbiome.entities;

import org.bitbiome.classes.CreateLocations;

import java.util.ArrayList;

public class Player {
    private String name;
    private float hp;
    private Location location;

    private ArrayList<Item> inventory;

    public Player(String name) {
        this.name = name;
        hp = 100.0F;
        location = CreateLocations.createForest();
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public float getHp() {
        return hp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public boolean addToInventory(Item item) {
        return inventory.add(item);
    }

    public boolean removeFromInventory(Item item) {
        return inventory.remove(item);
    }

}
