package org.bitbiome.commands;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



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

}
