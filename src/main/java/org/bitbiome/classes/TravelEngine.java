package org.bitbiome.classes;

import org.bitbiome.entities.Location;
import org.bitbiome.entities.Player;
import org.json.JSONArray;

import java.util.ArrayList;

public class TravelEngine {

    private JSONArray locations;
    JsonParser jp;
    private Player player;

    public TravelEngine(Player player) {
        jp = new JsonParser();
        locations = jp.getJSONObject("../gameconfig.json").getJSONArray("locations");
        this.player = player;
    }

    public void travelTo(Location location) {
        player.setLocation(location);
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

}
