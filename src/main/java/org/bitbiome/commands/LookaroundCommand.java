package org.bitbiome.commands;

import org.bitbiome.classes.JsonParser;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.bitbiome.entities.Location;
import org.bitbiome.entities.Mob;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LookaroundCommand implements CommandAPI{
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        StringBuilder s = new StringBuilder();
        Location location = travelEngine.getPlayer().getLocation();
        JsonParser jp = new JsonParser();
        JSONObject o = jp.getJSONObject("gameconfig.json");
        JSONArray locations = o.getJSONArray("locations");
        JSONObject locationObject = locations.getJSONObject(0);

        for (int i = 1; i < locations.length(); i++) {
            if(locations.getJSONObject(i).getString("name").equals(location.getName())){
                locationObject = locations.getJSONObject(i);
            }
        }
        JSONArray items = locationObject.getJSONArray("items");
        JSONArray mobs = locationObject.getJSONArray("mobs");

        ArrayList<Item> foundItems = location.getItemList();
        ArrayList<Mob> foundMobs = location.getMobList();
        s.append(foundItems).append(foundMobs);
        System.out.println(s);

    }

}
