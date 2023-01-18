package org.bitbiome.classes;

import org.bitbiome.entities.Item;
import org.bitbiome.entities.Location;
import org.bitbiome.entities.Mob;

import java.util.ArrayList;

public class CreateLocations {

    public static Location createForest() {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Mob> mobs = new ArrayList<>();
        String name = "Wald";
        return new Location(name, mobs, items);
    }

    public static Location createBeach() {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Mob> mobs = new ArrayList<>();
        String name = "Strand";
        return new Location(name, mobs, items);
    }
}
