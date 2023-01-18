package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;

import java.util.Scanner;

public class LocationCommand implements CommandAPI{

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println("Du befindest dich gerade hier: " + travelEngine.getPlayer().getLocation().getName());
    }
}
