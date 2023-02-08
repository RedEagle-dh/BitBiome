package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
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
        JSONObject o = JsonParser.getJSONObject("src/main/resources/playerconfig.json");
        JSONArray inventory = o.getJSONArray("inventory");

        ArrayList<Item> location = travelEngine.getPlayer().getLocation().getItemList();
        ArrayList<Item> getInventory = travelEngine.getPlayer().getInventory();

        System.out.println("Was willst du einsammeln?");
        String item = new String();
        item = scanner.nextLine();

        collectItem(location, item, o, inventory,getInventory);
    }
    public void collectItem(ArrayList<Item> location, String item, JSONObject o, JSONArray inventory, ArrayList<Item> getInventory) {
        for (int i = 0; i < location.size(); i++) {
            if (item.equals(location.get(i).getName())) {
                JSONObject o1 = new JSONObject();
                for (int j = 0; j < getInventory.size(); j++) {
                    if (getInventory.get(j).getName().equals(item)) {
                        getInventory.get(j).setAmount(getInventory.get(j).getAmount() + 1);
                        for (int k = 0; k < inventory.length(); k++) {
                            if (inventory.getJSONObject(k).getString("name").equals(item)) {
                                increaseAmountInPlayerConfig(inventory,k,o);
                                return;
                            }
                        }
                    }
                }
                writeNewItem(location, getInventory, o1, inventory, i, o);
            }
        } System.out.println("Es gibt kein Item, dass du einsammeln kannst.");
    }
    public void writeNewItem(ArrayList<Item> location, ArrayList<Item> getInventory, JSONObject o1, JSONArray inventory, int i, JSONObject o){
        o1.put("name", location.get(i).getName()).put("doesDamage", location.get(i).doesDamage()).put("damage", location.get(i).getDamage()).put("amount", 1).put("durability", 1000);
        inventory.put(o1);
        JsonParser.writeObject("playerconfig.json", o);
        getInventory.add(location.get(i));
        location.remove(i);
    }
    public void increaseAmountInPlayerConfig(JSONArray inventory, int k, JSONObject o){
        int amountItemsInPlayerconfig = 0;
        amountItemsInPlayerconfig = inventory.getJSONObject(k).getInt("amount");
        inventory.getJSONObject(k).put("amount", amountItemsInPlayerconfig + 1);
        JsonParser.writeObject("playerconfig.json", o);
        System.out.println(Colors.ANSI_YELLOW +"Du hast das Item eingesammelt."+ Colors.ANSI_RESET);
    }
}

