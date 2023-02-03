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

        Random random = new Random();
        int randomNumberItems = random.nextInt(items.length()+1);
        int randomNumberMobs = random.nextInt(mobs.length()+1);
        ArrayList<Item> foundItems = location.getItemList();
        foundItems.removeAll(foundItems);
        ArrayList<Mob> foundMobs = location.getMobList();
        foundMobs.removeAll(foundMobs);

        for (int i=0; i<randomNumberItems; i++){
            String s1 = items.getString(random.nextInt(items.length()));
            String resourceName = "./../../../items.json";
            InputStream is = JsonParser.class.getResourceAsStream(resourceName);
            if (is == null) {
                throw new NullPointerException("Cannot find resource file " + resourceName);
            }

            JSONTokener tokener = new JSONTokener(is);
            JSONArray jp3 = new JSONArray(tokener);
            JSONObject jp2= jp3.getJSONObject(0);
            for (int j=1; j<jp3.length(); j++ ){
                if(jp3.getJSONObject(j).getString("name").equals(s1)){
                    jp2 = jp3.getJSONObject(j);
                    break;
                }
            }
            Item randomItem = new Item (jp2.getString("name"),jp2.getBoolean("doesDamage"),jp2.getFloat("damage"),1);
            foundItems.add(randomItem);
        }
        for (int i=0; i<randomNumberMobs; i++){
            JSONObject jp2 = mobs.getJSONObject(random.nextInt(mobs.length()));
            Mob randomMob = new Mob (jp2.getString("name"),jp2.getBoolean("isFriendly"),jp2.getFloat("hp"),jp2.getFloat("damage"));
            foundMobs.add(randomMob);
        }
        s.append(foundItems).append(foundMobs);
        System.out.println(s);

    }

}
