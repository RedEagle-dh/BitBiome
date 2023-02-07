package org.bitbiome.commands;

import org.bitbiome.classes.Colors;

import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.bitbiome.entities.Location;
import org.bitbiome.entities.Mob;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Scanner;


public class TravelCommand implements CommandAPI {

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        print(Colors.ANSI_BLUE + "Du hast dein Travel-Pad gezückt. Wohin möchtest du reisen?" + Colors.ANSI_RESET);
        JSONArray locations = travelEngine.getLocationList();
        for (int i = 0; i < locations.length(); i++) {
            print("- " + locations.getJSONObject(i).getString("name"));
        }

        String locationName = scanner.nextLine();
        if (travelEngine.locationExists(locationName)) {
            travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
            print(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
        } else {
            print(Colors.ANSI_BLUE + "Du hast dein Travel-Pad weggesteckt." + Colors.ANSI_RESET);
        }
    }

    public String print(String message) {
        System.out.println(message);
        return message;
    }
}
