package org.bitbiome.commands;

import java.util.Scanner;

import org.bitbiome.classes.JsonParser;
import org.json.*;

public class UseCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println(getUseMessage(message.split(" ", 2)[1]));
    }

    private String getUseMessage(String msg) {
        String item = msg.split(" on ")[0];
        String target = msg.split(" on ")[1];
        return useItem(item, target);
    }

    private String useItem(String item, String target) {
        return "You used " + item + " on " + target;
    }

    private JSONObject getItem(String item) {
        JSONArray inventory = JsonParser.getJSONObject("playerconfig.json").getJSONArray("inventory");
            for(int i = 0; i < inventory.length(); i++) {
                JSONObject currentItem = inventory.getJSONObject(i);
                if(currentItem.getString("name").equals(item))
                    return currentItem;
            }
        return null;
    }

    private JSONObject getTarget(String target) {
        String currentLocation = JsonParser.getJSONObject("playerconfig").getString("currentLocation");
        JSONArray locations = JsonParser.getJSONObject("gameconfig").getJSONArray("locations");
        for(int i = 0; i < locations.length(); i++) {
            JSONObject location = locations.getJSONObject(i);
            if(locations.getJSONObject(i).getString("name").equals(currentLocation)) {
                JSONArray targets = location.getJSONArray("mobs");
                for(int j = 0; j < targets.length(); j++) {
                    JSONObject mob = targets.getJSONObject(j);
                    if(mob.getString("name").equals(target))
                        return mob;
                }
                break;
            }
        }
        return null;
    }
}