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
        mob1.put("damage", "5");
        JSONObject mob2 = new JSONObject();
        mob2.put("name", "Yeti");
        mob2.put("isFriendly", false);
        mob2.put("hp", 20);
        mob2.put("damage", "10");
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
        foundItems.add(new Item("Holz", true, "10", 1,2));
        foundItems.add(new Item("Stein", true, "10", 1, 3));
        foundItems.add(new Item("Sand", false, "1", 1,3));
        command.getItemsOutput(randomNumberItems, outputMessage, foundItems);
        String expectedOutput = Colors.ANSI_BLUE+ "Huch, was liegt denn hier rum?\n" + Colors.ANSI_RESET+
                "- Holz\n- Stein\n- Sand\n" +
                Colors.ANSI_BLUE  +"Schnell, sammel es ein!\n"+ Colors.ANSI_RESET;
        assertEquals(expectedOutput, outputMessage.toString());
    }
    @Test
    public void testGetItemsOutputWithoutItems() {
        LookaroundCommand command = new LookaroundCommand();
        int randomNumberItems = 0;
        StringBuilder outputMessage = new StringBuilder();
        ArrayList<Item> foundItems = new ArrayList<Item>();
        command.getItemsOutput(randomNumberItems, outputMessage, foundItems);
        String expectedOutput = Colors.ANSI_BLUE+ "Hier gibt es leider nichts für dich zum Einsammeln.\n"+ Colors.ANSI_RESET;
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

        String expectedOutput = Colors.ANSI_RED+"Achtung, hier lauern Gefahren!"+Colors.ANSI_RESET +"Sei auf der Hut vor: \n- Big Foot\n- Yeti\n";
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
        JSONArray items = new JSONArray("[{\"name\":\"Holz\",\"doesDamage\":true,\"damage\":\"1.0\"},{\"name\":\"Stein\",\"doesDamage\":false,\"damage\":\"10.0\"}]");
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < randomNumberItems; i++) {
            JSONObject itemObject = items.getJSONObject(i);
            Item item = new Item(itemObject.getString("name"), itemObject.getBoolean("doesDamage"),
                    itemObject.getString("damage"), 1, 3);
            result.add(item);
        }
        assertEquals(2, result.size());
        assertEquals("Holz", result.get(0).getName());
        assertEquals("Stein", result.get(1).getName());
    }
    @Test
    public void testWaldDescription() {
        LookaroundCommand command = new LookaroundCommand();
        ArrayList<Mob> enemies = new ArrayList<Mob>();
        enemies.add(new Mob("Bigfoot", false, 50,20));
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Holz",true, "10", 1,3));
        Location location = new Location("Wald",enemies, items);
        StringBuilder outputMessage = new StringBuilder();

        command.getLocationDescription(location, outputMessage);

        String expectedDescription = "Du befindest dich mitten im Wald, um dich herum siehst du hohe Buchen, kleine Sträucher und Farne.\n" +
                "Der Boden ist mit weichem Moos, Pilzen und Laub bedeckt, in der Nähe hörst du Vögel munter zwitschern und\n" +
                "einen kleinen Bach, der sich durch das dichte Unterholz schlängelt." +
                " Schau mal, dort hinten in der Ferne ist ein Eichhörnchen! \n";

        assertEquals(expectedDescription, outputMessage.toString());
    }
    @Test
    public void testStrandDescription() {
        LookaroundCommand command = new LookaroundCommand();
        ArrayList<Mob> enemies = new ArrayList<Mob>();
        enemies.add(new Mob("Bigfoot", false, 50,20));
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Holz",true, "10", 1, 5));
        Location location = new Location("Strand",enemies, items);
        StringBuilder outputMessage = new StringBuilder();

        command.getLocationDescription(location, outputMessage);

        String expectedDescription = "Du befindest dich mitten am Strand und blickst auf das Meer, das sich bis zum Horizont erstreckt.\n" +
                "Du spürst den Sand an deinen Füßen, du hörst das weiche Rauschen des Meeres und das Lachen der Möwen über dir.\n" +
                "Rechts und links von dir erstreckt sich der weite, weiße Sandstrand, dort hinten bauen Kinder eine Sandburg.\n" +
                "Es gibt ein paar Palmen, die den Strand säumen und weit in der Ferne ragen Felsen aus dem Meer.\n";

        assertEquals(expectedDescription, outputMessage.toString());
    }
    @Test
    public void testUnknownLocationDescription() {
        LookaroundCommand command = new LookaroundCommand();
        ArrayList<Mob> enemies = new ArrayList<Mob>();
        enemies.add(new Mob("unknown", false, 50,20));
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("unknown",true, "10", 1, 5));
        Location location = new Location("Unknown",enemies, items);
        StringBuilder outputMessage = new StringBuilder();

        command.getLocationDescription(location, outputMessage);

        assertEquals("", outputMessage.toString());
    }
    @Test
    public void testWinterlandDescription() {
        LookaroundCommand command = new LookaroundCommand();
        ArrayList<Mob> enemies = new ArrayList<Mob>();
        enemies.add(new Mob("Yeti", false, 50,20));
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Schnee",true, "10", 1, 5));
        Location location = new Location("Winterland",enemies, items);
        StringBuilder outputMessage = new StringBuilder();

        command.getLocationDescription(location, outputMessage);

        String expectedDescription = "Um dich herum ragen hohe Berge in den Himmel, bedeckt von einer dicken Schicht aus Schnee. Du hörst\n" +
                "das Knirschen des Schnees unter deinen Füßen und das Rauschen des eisigen Windes. In der Ferne siehst du Tannenbäume,\n" +
                "die sich unter der Last des Schnees biegen, und dichte Flocken fallen sanft aus dem grauen Himmel. Es ist kalt, du siehst,\n" +
                "wie dein Atem kleine Wolken bildet. Es ist still, aber auch ein wenig unheimlich.\n";

        assertEquals(expectedDescription, outputMessage.toString());
    }

}
