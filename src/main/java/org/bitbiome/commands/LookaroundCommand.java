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
        JSONObject gameConfig = jp.getJSONObject("gameconfig.json");
        JSONArray locations = gameConfig.getJSONArray("locations");
        JSONObject locationObject = getLocationObject(location.getName(), locations);
        JSONArray items = locationObject.getJSONArray("items");
        JSONArray mobs = locationObject.getJSONArray("mobs");

        Random random = new Random();
        int randomNumberItems = random.nextInt(items.length()+1);
        int randomNumberMobs = random.nextInt(mobs.length()+1);
        ArrayList<Item> foundItems = location.getItemList();
        foundItems.removeAll(foundItems);
        ArrayList<Mob> foundMobs = location.getMobList();
        foundMobs.removeAll(foundMobs);
        foundItems = getRandomItem(randomNumberItems, random, items, foundItems);
        foundMobs = getRandomMob(randomNumberMobs,random,mobs,foundMobs);

        if (location.getName().equals("Wald")){
            s.append("Du befindest dich mitten im Wald, um dich herum siehst du hohe Buchen, kleine Sträucher und Farne.\n" +
                    "Der Boden ist mit weichem Moos, Pilzen und Laub bedeckt, in der Nähe hörst du Vögel munter zwitschern und\n" +
                    "einen kleinen Bach, der sich durch das dichte Unterholz schlängelt." +
                    " Schau mal, dort hinten in der Ferne ist ein Eichhörnchen! \n");
        }
        if (location.getName().equals("Strand")){
            s.append("Du befindest dich mitten am Strand und blickst auf das Meer, das sich bis zum Horizont erstreckt.\n" +
                    "Du spürst den Sand an deinen Füßen, du hörst das weiche Rauschen des Meeres und das Lachen der Möwen über dir.\n" +
                    "Rechts und links von dir erstreckt sich der weite, weiße Sandstrand, dort hinten bauen Kinder eine Sandburg.\n" +
                    "Es gibt ein paar Palmen, die den Strand säumen und Strandliegen und -schirme, weit in der Ferne ragen Felsen aus dem Meer.\n");

        }
        if (randomNumberItems != 0){
            s.append("Huch, was liegt denn hier rum?\n");
            for (int i = 0; i < foundItems.size(); i++){
                s. append( "- ").append(foundItems.get(i).getName()+"\n");
            }
            s.append("Schnell, sammel es ein!\n");
        }
        else {
            s.append("Hier gibt es leider nichts für dich zum Einsammeln.\n");
        }
        if (randomNumberMobs != 0){
            s.append("Achtung, hier lauern Gefahren! Sei auf der Hut vor: \n");
            for (int i = 0; i < foundMobs.size(); i++){
                s. append( "- ").append(foundMobs.get(i).getName()+"\n");
            }
        }
        //gibt es eigentlich auch Hindernisse, wie zum Beispiel einen umgefallenen Baumstamm, oder Höhle, Hütte, zum Erkunden in der jeweiligen Welt?
        if((randomNumberMobs ==0) && (randomNumberItems == 0)){
            s.append("Hier gibt es sonst nichts weiter zu sehen. Reise weiter!\n");
        }
        System.out.println(s);

    }
    public JSONObject getLocationObject(String locationName, JSONArray locations) {
        for (int i = 1; i < locations.length(); i++) {
            if(locations.getJSONObject(i).getString("name").equals(locationName)){
                return locations.getJSONObject(i);
            }
        }
        return locations.getJSONObject(0);
    }
    public ArrayList<Item> getRandomItem(int randomNumberItems, Random random, JSONArray items, ArrayList<Item> foundItems ) {
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
        return foundItems;
    }

    public ArrayList<Mob> getRandomMob(int randomNumberMobs, Random random, JSONArray mobs, ArrayList<Mob> foundMobs){
        for (int i=0; i<randomNumberMobs; i++){
            JSONObject jp2 = mobs.getJSONObject(random.nextInt(mobs.length()));
            Mob randomMob = new Mob (jp2.getString("name"),jp2.getBoolean("isFriendly"),jp2.getFloat("hp"),jp2.getFloat("damage"));
            foundMobs.add(randomMob);
        } return foundMobs;
    }


}
