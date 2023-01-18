package org.bitbiome.classes;

import java.util.ArrayList;

public class CreateLocations {

    public static Location createForest() {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Mob> mobs = new ArrayList<>();
        String name = "Wald";
        return new Location(name, mobs, items);
    }
}
