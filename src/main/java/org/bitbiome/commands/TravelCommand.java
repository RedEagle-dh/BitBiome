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
    public void exittravelCommand() {
        System.out.println(Colors.ANSI_BLUE + "Du hast dein Travel-Pad weggesteckt." + Colors.ANSI_RESET);
    }

    public void travelCommand() {

    }

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(Colors.ANSI_BLUE + "Du hast dein Travel-Pad gezückt. Wohin möchtest du reisen?" + Colors.ANSI_RESET);
        JSONArray locations = travelEngine.getLocationList();
        String locationName;
        String locationWueste = locations.getJSONObject(5).getString("name");
        String locationGruenland = locations.getJSONObject(4).getString("name");
        String locationWinterland = locations.getJSONObject(2).getString("name");
        String locationStrand = locations.getJSONObject(1).getString("name");
        String locationWald = locations.getJSONObject(0).getString("name");
        String locationBerge = locations.getJSONObject(3).getString("name");
        if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wald")) {
            System.out.println("- " + locationStrand + "\n" + "- " + locationGruenland + "\n" + "- " + locationBerge);

            locationName = scanner.nextLine();
            if (travelEngine.locationExistsWald(locationName)) {
                travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
                System.out.println(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
            } else {
                exittravelCommand();
                return;
            }

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Strand")) {
            System.out.println("- " + locationWueste + "\n" + "- " + locationWald);

            locationName = scanner.nextLine();
            if (travelEngine.locationExistsStrand(locationName)) {
                travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
                System.out.println(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
            } else {
                exittravelCommand();
                return;
            }

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Gruenland")) {
            System.out.println("- " + locationWueste + "\n" + "- " + locationWald + "\n" + "- " + locationWinterland);

            locationName = scanner.nextLine();
            if (travelEngine.locationExistsGruenland(locationName)) {
                travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
                System.out.println(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
            } else {
                exittravelCommand();
                return;
            }

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Berge")) {
            System.out.println("- " + locationWald + "\n" + "- " + locationWinterland);

            locationName = scanner.nextLine();
            if (travelEngine.locationExistsBerge(locationName)) {
                travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
                System.out.println(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
            } else {
                exittravelCommand();
                return;
            }

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Winterland")) {
            System.out.println("- " + locationGruenland + "\n" + "- " + locationBerge);

            locationName = scanner.nextLine();
            if (travelEngine.locationExistsWinterland(locationName)) {
                travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
                System.out.println(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
            } else {
                exittravelCommand();
                return;
            }

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wueste")) {
            System.out.println("- " + locationStrand + "\n" + "- " + locationGruenland);

            locationName = scanner.nextLine();
            if (travelEngine.locationExistsWueste(locationName)) {
                travelEngine.travelTo(new Location(locationName, new ArrayList<Mob>(), new ArrayList<Item>()));
                System.out.println(Colors.ANSI_BLUE + "Du bist nun hierhin gereist: " + locationName + "\n" + Colors.ANSI_RESET);
            } else {
                exittravelCommand();
                return;
            }
        }
    }
}
