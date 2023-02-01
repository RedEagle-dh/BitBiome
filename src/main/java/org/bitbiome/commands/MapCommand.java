package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;

import java.util.Scanner;

public class MapCommand implements CommandAPI{

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getMapMessage());
    }
    public static String getMapMessage() {
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append("Map:\n")
                .append("Wueste         Gruendland      Winterland\n\n")
                .append("Strand         Wald            Berge\n\n");
        return outputMessage.toString();
    }


}
