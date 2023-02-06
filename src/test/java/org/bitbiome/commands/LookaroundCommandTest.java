package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.bitbiome.entities.Item;
import org.bitbiome.entities.Location;
import org.bitbiome.entities.Mob;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LookaroundCommandTest {
    private JSONArray locations;

    @Test
    public void testGetLocationObject(){
        LookaroundCommand command = new LookaroundCommand();
        locations = new JSONArray();
        JSONObject location1 = new JSONObject();
        location1.put("name", "Wald");
        location1.put("description", "Es gibt Bäume und Sträucher");
        JSONObject location2 = new JSONObject();
        location2.put("name", "Strand");
        location2.put("description", "Weiter, weißer Sandstrand am Meer");
        locations.put(location1);
        locations.put(location2);

        JSONObject result = command.getLocationObject("Wald", locations);
        assertEquals("Wald", result.getString("name"));
        assertEquals("Es gibt Bäume und Sträucher", result.getString("description"));

        result = command.getLocationObject("Strand", locations);
        assertEquals("Strand", result.getString("name"));
        assertEquals("Weiter, weißer Sandstrand am Meer", result.getString("description"));

        result = command.getLocationObject("not existing location", locations);
        assertEquals("Wald", result.getString("name"));
        assertEquals("Es gibt Bäume und Sträucher", result.getString("description"));
    }

    @Test
    public void testGetRandomMob() {
        LookaroundCommand command = new LookaroundCommand();
        int randomNumberMobs = 2;
        Random random = new Random();
        JSONArray mobs = new JSONArray();
        JSONObject mob1 = new JSONObject();
        mob1.put("name", "BigFoot");
        mob1.put("isFriendly", true);
        mob1.put("hp", 10);
        mob1.put("damage", 5);
        JSONObject mob2 = new JSONObject();
        mob2.put("name", "Yeti");
        mob2.put("isFriendly", false);
        mob2.put("hp", 20);
        mob2.put("damage", 10);
        mobs.put(mob1);
        mobs.put(mob2);
        ArrayList<Mob> foundMobs = new ArrayList<>();
        ArrayList<Mob> result = command.getRandomMob(randomNumberMobs, random, mobs, foundMobs);

        assertEquals(randomNumberMobs, result.size());
        for (Mob mob : result) {
            assertTrue(mob.getName().equals("BigFoot") || mob.getName().equals("Yeti"));
        }
    }
    @Test
    public void testGetItemsOutputWithItems() {
        LookaroundCommand command = new LookaroundCommand();
        int randomNumberItems = 3;
        StringBuilder outputMessage = new StringBuilder();
        ArrayList<Item> foundItems = new ArrayList<Item>();
        foundItems.add(new Item("Holz", true, 10, 1));
        foundItems.add(new Item("Stein", true, 10, 1));
        foundItems.add(new Item("Sand", false, 1, 1));
        command.getItemsOutput(randomNumberItems, outputMessage, foundItems);
        String expectedOutput = "Huch, was liegt denn hier rum?\n- Holz\n- Stein\n- Sand\nSchnell, sammel es ein!\n";
        assertEquals(expectedOutput, outputMessage.toString());
    }
    @Test
    public void testGetItemsOutputWithoutItems() {
        LookaroundCommand command = new LookaroundCommand();
        int randomNumberItems = 0;
        StringBuilder outputMessage = new StringBuilder();
        ArrayList<Item> foundItems = new ArrayList<Item>();
        command.getItemsOutput(randomNumberItems, outputMessage, foundItems);
        String expectedOutput = "Hier gibt es leider nichts für dich zum Einsammeln.\n";
        assertEquals(expectedOutput, outputMessage.toString());
    }
    @Test
    public void testGetMobsOutputWithMobs() {
        LookaroundCommand command = new LookaroundCommand();
        int randomNumberMobs = 2;
        int randomNumberItems = 0;
        StringBuilder outputMessage = new StringBuilder();
        ArrayList<Mob> foundMobs = new ArrayList<>();
        foundMobs.add(new Mob("Big Foot", true, 50, 15));
        foundMobs.add(new Mob("Yeti", false, 70, 30));

        command.getMobsOutput( randomNumberItems,randomNumberMobs, outputMessage, foundMobs);

        String expectedOutput = "Achtung, hier lauern Gefahren! Sei auf der Hut vor: \n- Big Foot\n- Yeti\n";
        assertEquals(expectedOutput, outputMessage.toString());
    }
    @Test
    public void testGetMobsOutputWithoutMobsAndItems() {
        LookaroundCommand command = new LookaroundCommand();
        int randomNumberMobs = 0;
        int randomNumberItems = 0;
        StringBuilder outputMessage = new StringBuilder();
        ArrayList<Mob> foundMobs = new ArrayList<>();

        command.getMobsOutput(randomNumberMobs, randomNumberItems, outputMessage, foundMobs);

        String expectedOutput = "Hier gibt es sonst nichts weiter zu sehen. Reise weiter!\n";
        assertEquals(expectedOutput, outputMessage.toString());
    }
    @Test
    void testGetRandomItem() throws Exception {
        int randomNumberItems = 2;
        JSONArray items = new JSONArray("[{\"name\":\"Holz\",\"doesDamage\":true,\"damage\":1.0},{\"name\":\"Stein\",\"doesDamage\":false,\"damage\":10.0}]");
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < randomNumberItems; i++) {
            JSONObject itemObject = items.getJSONObject(i);
            Item item = new Item(itemObject.getString("name"), itemObject.getBoolean("doesDamage"),
                    itemObject.getFloat("damage"), 1);
            result.add(item);
        }
        assertEquals(2, result.size());
        assertEquals("Holz", result.get(0).getName());
        assertEquals("Stein", result.get(1).getName());
    }

}
