package org.bitbiome.entities;


import org.bitbiome.classes.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.ArrayList;

public class Player {
    private String name;
    private float hp;



    private int gold;
    private Location location;

    private ArrayList<Item> inventory;



    public Player(String name) {
        this.name = name;
        hp = 100.0F;
        location = new Location(JsonParser.getJSONObject("src/main/resources/playerconfig.json").getString("currentLocation"), new ArrayList<>(), new ArrayList<>());
        inventory = new ArrayList<>();
        JSONArray items = JsonParser.getJSONObject("src/main/resources/playerconfig.json").getJSONArray("inventory");
        for (int i = 0; i < items.length(); i++) {
            JSONObject o = items.getJSONObject(i);
            inventory.add(new Item(o.getString("name"), o.getBoolean("doesDamage"), o.getString("damage"), o.getInt("amount"), o.getInt("gold")));
        }



    }

    public Player() {
        
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

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() { return (int) gold; }

    public int setGold(int gold) { this.gold = gold; return gold; }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
