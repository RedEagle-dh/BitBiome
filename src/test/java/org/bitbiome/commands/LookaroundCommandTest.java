package org.bitbiome.commands;

import org.bitbiome.entities.Item;
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

}
