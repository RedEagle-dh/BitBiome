package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;

import java.util.Scanner;

public class LocationCommand implements CommandAPI{

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getLocationMessage(travelEngine));
    }


    public static String getLocationMessage(TravelEngine travelEngine) {
        return "Du befindest dich gerade hier: " + travelEngine.getPlayer().getLocation().getName();
    }
}
