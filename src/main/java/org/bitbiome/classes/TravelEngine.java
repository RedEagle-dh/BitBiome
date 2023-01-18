package org.bitbiome.classes;

import org.bitbiome.entities.Location;
import org.bitbiome.entities.Player;

public class TravelEngine {

    private Location location;
    private Player player;

    public TravelEngine(Player player) {
        this.player = player;
    }

    public void travelTo(Location location) {
        player.setLocation(location);
    }

    public Player getPlayer() {
        return player;
    }

}
