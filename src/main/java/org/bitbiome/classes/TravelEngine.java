package org.bitbiome.classes;

import org.bitbiome.entities.Location;
import org.bitbiome.entities.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TravelEngine {

    private JSONArray locations;
    private Player player;

    public TravelEngine(Player player) {
        locations = JsonParser.getJSONObject("src/main/resources/gameconfig.json").getJSONArray("locations");
        this.player = player;
    }

    public void travelTo(Location location) {
        player.setLocation(location);
        JSONObject jObj = JsonParser.getJSONObject("src/main/resources/playerconfig.json");
        jObj.put("currentLocation", location.getName());

        JsonParser.writeObject("src/main/resources/playerconfig.json", jObj);
    }

    public Player getPlayer() {
        return player;
    }

    public JSONArray getLocationList() {
        return locations;
    }

    public boolean locationExists(String name) {
        boolean found = false;
        for (int i = 0; i < locations.length(); i++)
            if (locations.getJSONObject(i).getString("name").equals(name)) {
                found = true;
            }
        return found;
    }

    public Location getLocationByName(String name) {
        JSONObject gameconfig = JsonParser.getJSONObject("src/main/resources/gameconfig.json");
        JSONArray locations = gameconfig.getJSONArray("locations");
        JSONObject location = null;
        if (locationExists(name)) {
            for (int i = 0; i < locations.length(); i++) {
                if (locations.getJSONObject(i).getString("name").equals(name)) {
                    location = locations.getJSONObject(i);
                }
            }
            assert location != null;
            //TODO Create Location by name and add mobs and times to the location
            JSONArray items = location.getJSONArray("items");
            JSONArray mobs = location.getJSONArray("mobs");
            System.out.println(items.toString(1));
            System.out.println(mobs.toString(1));
            return new Location(name, new ArrayList<>(), new ArrayList<>());
        } else {
            return null;
        }
    }
}
