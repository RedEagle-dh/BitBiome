package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.bitbiome.classes.JsonParser;
import org.bitbiome.classes.Shop;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.*;
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
        StringBuilder outputMessage = new StringBuilder();
        Location location = travelEngine.getPlayer().getLocation();
        JsonParser jp = new JsonParser();
        JSONObject gameConfig = jp.getJSONObject("src/main/resources/gameconfig.json");
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

        getLocationDescription(location,outputMessage);
        getItemsOutput(randomNumberItems,outputMessage,foundItems);
        getMobsOutput(randomNumberItems,randomNumberMobs,outputMessage, foundMobs);
        System.out.println(outputMessage);

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

            JSONArray jp3 = Shop.returnJSONArrayOfAllItems();
            JSONObject jp2= jp3.getJSONObject(0);
            for (int j=1; j<jp3.length(); j++ ){
                if(jp3.getJSONObject(j).getString("name").equals(s1)){
                    jp2 = jp3.getJSONObject(j);
                    break;
                }
            }
            Item randomItem = new Item (jp2.getString("name"),jp2.getBoolean("doesDamage"),jp2.getString("damage"),1, jp2.getInt("gold"));
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

    public void getItemsOutput(int randomNumberItems, StringBuilder outputMessage, ArrayList<Item> foundItems){
        if (randomNumberItems != 0){
            outputMessage.append(Colors.ANSI_BLUE  +"Huch, was liegt denn hier rum?\n"+ Colors.ANSI_RESET);
            for (int i = 0; i < foundItems.size(); i++){
                outputMessage. append("- ").append(foundItems.get(i).getName()+"\n");
            }
            outputMessage.append(Colors.ANSI_BLUE  +"Schnell, sammel es ein!\n"+ Colors.ANSI_RESET);
        }
        else {
            outputMessage.append(Colors.ANSI_BLUE+ "Hier gibt es leider nichts für dich zum Einsammeln.\n"+ Colors.ANSI_RESET);
        }
    }
    public void getMobsOutput(int randomNumberItems, int randomNumberMobs, StringBuilder outputMessage, ArrayList<Mob> foundMobs){
        if (randomNumberMobs != 0){
            outputMessage.append(Colors.ANSI_RED+"Achtung, hier lauern Gefahren!"+Colors.ANSI_RESET +"Sei auf der Hut vor: \n");
            for (int i = 0; i < foundMobs.size(); i++){
                outputMessage. append( "- ").append(foundMobs.get(i).getName()+"\n");
            }
        }
        if((randomNumberMobs ==0) && (randomNumberItems == 0)){
            outputMessage.append("Hier gibt es sonst nichts weiter zu sehen. Reise weiter!\n");
        }
    }
    public void getLocationDescription(Location location, StringBuilder outputMessage) {
        switch (location.getName()) {
            case "Wald" ->
                    outputMessage.append("Du befindest dich mitten im Wald, um dich herum siehst du hohe Buchen, kleine Sträucher und Farne.\n" +
                            "Der Boden ist mit weichem Moos, Pilzen und Laub bedeckt, in der Nähe hörst du Vögel munter zwitschern und\n" +
                            "einen kleinen Bach, der sich durch das dichte Unterholz schlängelt." +
                            " Schau mal, dort hinten in der Ferne ist ein Eichhörnchen! \n");
            case "Strand" ->
                    outputMessage.append("Du befindest dich mitten am Strand und blickst auf das Meer, das sich bis zum Horizont erstreckt.\n" +
                            "Du spürst den Sand an deinen Füßen, du hörst das weiche Rauschen des Meeres und das Lachen der Möwen über dir.\n" +
                            "Rechts und links von dir erstreckt sich der weite, weiße Sandstrand, dort hinten bauen Kinder eine Sandburg.\n" +
                            "Es gibt ein paar Palmen, die den Strand säumen und weit in der Ferne ragen Felsen aus dem Meer.\n");
            case "Winterland" ->
                    outputMessage.append("Um dich herum ragen hohe Berge in den Himmel, bedeckt von einer dicken Schicht aus Schnee. Du hörst\n" +
                            "das Knirschen des Schnees unter deinen Füßen und das Rauschen des eisigen Windes. In der Ferne siehst du Tannenbäume,\n" +
                            "die sich unter der Last des Schnees biegen, und dichte Flocken fallen sanft aus dem grauen Himmel. Es ist kalt, du siehst,\n" +
                            "wie dein Atem kleine Wolken bildet. Es ist still, aber auch ein wenig unheimlich.\n");
            case "Berge"->
                    outputMessage.append("Du befindest dich in einer majestätischen Berglandschaft mit hohen Gipfen und tiefen Tälern.\n" +
                            "Die Luft ist frisch und klar, der Klang von rauschenden Bächen und Wasserfällen erfüllt die Umgebung.\n" +
                            "Die Berge sind mit grünen Wäldern bedeckt und vereinzelt siehst du wilde Tiere herumstreifen.\n");
            case "Grünland"->
                    outputMessage.append("Du befindest dich in einer weiten und grünen Landschaft. Überall um dich herum wachsen hohe Gräser und Wildblumen. \n" +
                            "In der Ferne erkennst du sanfte Hügel mit einer Herde von Schafen und Kühen.Die Luft ist erfüllt von dem Duft der Natur \n" +
                            "und dem Summen von Insekten. Es herrscht eine friedliche Stille, nur unterbrochen vom gelegentlichen Ruf eines Vogels.");
            case "Wüste"->
                    outputMessage.append("Du befindest dich mitten in der Wüste. Weit und breit ist nichts anderes zu sehen außer Dünen, vertrocknete Sträucher und Tonnen von Sand.\n" +
                            "Es ist staubig, der sandige Boden unter deinen Füßen knirscht bei jedem Schritt und die Sonnen brennt auf dich herab. Nimm dich in Acht vor der Wüstenhitze \n" +
                            "und den Gefahren, die hinter den Dünen lauern. Beeil dich, aus dieser unendlichen Ebene zu entkommen.\n");
            default -> {
            }
            //location description not found
        }
    }


}
