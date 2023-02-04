package org.bitbiome.commands;

import org.bitbiome.classes.JsonParser;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        StringBuilder s = new StringBuilder();
        JsonParser jp = new JsonParser();
        JSONObject o = jp.getJSONObject("playerconfig.json");
        JSONArray inventory = o.getJSONArray("inventory");

        ArrayList<Item> location = travelEngine.getPlayer().getLocation().getItemList();
        ArrayList<Item> getInventory = travelEngine.getPlayer().getInventory();

        System.out.println("Was willst du einsammeln?");
        String item = new String();
        item = scanner.nextLine();

        collectItem(location, item, jp, o, inventory,getInventory);
    }

    public void collectItem(ArrayList<Item> location, String item, JsonParser jp, JSONObject o, JSONArray inventory, ArrayList<Item> getInventory) {
        for (int i = 0; i < location.size(); i++) {
            if (item.equals(location.get(i).getName())) {
                JSONObject o1 = new JSONObject();
                for (int j = 0; j < getInventory.size(); j++) {
                    if (getInventory.get(j).getName().equals(item)) {
                        getInventory.get(j).setAmount(getInventory.get(j).getAmount() + 1);
                        for (int k = 0; k < inventory.length(); k++) {
                            if (inventory.getJSONObject(k).getString("name").equals(item)) {
                                increaseAmountInPlayerConfig(inventory,k,jp,o);
                                return;
                            }
                        }
                    }
                }
                writeNewItem(location, getInventory, o1, inventory, i, jp, o);
            }
        } System.out.println("Es gibt kein Item, dass du einsammeln kannst.");
    }
    public void writeNewItem(ArrayList<Item> location, ArrayList<Item> getInventory, JSONObject o1, JSONArray inventory, int i, JsonParser jp, JSONObject o){
        o1.put("name", location.get(i).getName());
        o1.put("doesDamage", location.get(i).doesDamage());
        o1.put("damage", location.get(i).getDamage());
        o1.put("amount", 1);
        o1.put("durability", 1000);
        o.getJSONArray("inventory").put(o1);
        jp.writeObject("playerconfig.json", o);
        getInventory.add(location.get(i));
        location.remove(i);
    }
    public void increaseAmountInPlayerConfig(JSONArray inventory, int k, JsonParser jp, JSONObject o){
        JSONObject o2 = new JSONObject();
        int amountItemsInPlayerconfig = 0;
        amountItemsInPlayerconfig = inventory.getJSONObject(k).getInt("amount");
        inventory.getJSONObject(k).put("amount", amountItemsInPlayerconfig + 1);
        jp.writeObject("playerconfig.json", o);
        System.out.println("Du hast das Item eingesammelt.");
    }
}

