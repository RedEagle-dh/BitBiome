package org.bitbiome.commands;
import org.bitbiome.classes.TravelEngine;
import org.json.JSONArray;
import java.util.Scanner;
import org.bitbiome.classes.Colors;

public class MapCommand implements CommandAPI{
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getMapMessage(travelEngine));
    }
    public static String getLocationMessage(TravelEngine travelEngine) {
        return "Du befindest dich gerade hier: " + Colors.ANSI_GREEN + travelEngine.getPlayer().getLocation().getName() + "\n" + Colors.ANSI_RESET;
    }
    private static String textColor(String text, String color) {
        return color + text + Colors.ANSI_RESET;
    }

    private static String textBlack(String text) {
        return textColor(text,Colors.ANSI_BRIGHT_BLACK);
    }
    private static String textBlue(String text) {
        return textColor(text,Colors.ANSI_BLUE);
    }
    private static String textGreen(String text) {
        return textColor(text,Colors.ANSI_GREEN);
    }
    public static String getMapMessage(TravelEngine travelEngine) {
        StringBuilder outputMessage = new StringBuilder();
        JSONArray locations = travelEngine.getLocationList();
        String locationWueste = locations.getJSONObject(5).getString("name");
        String locationGruenland = locations.getJSONObject(4).getString("name");
        String locationWinterland = locations.getJSONObject(2).getString("name");
        String locationStrand = locations.getJSONObject(1).getString("name");
        String locationWald = locations.getJSONObject(0).getString("name");
        String locationBerge = locations.getJSONObject(3).getString("name");
        if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wald")) {
            outputMessage
                    .append(getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\n")
                    .append("Deine Karte:\n\n")
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlack(locationWueste) + "             |           " + textBlue(locationGruenland) + "            |           " + textBlack(locationWinterland) + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlue(locationStrand) + "             |              " + textGreen(locationWald) + "              |              " + textBlue(locationBerge) + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");
        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Strand")) {
            outputMessage
                    .append(getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\n")
                    .append("Deine Karte:\n\n")
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlue(locationWueste) + "             |           " + textBlack(locationGruenland) + "            |           " + textBlack(locationWinterland) + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textGreen(locationStrand) + "             |              " + textBlue(locationWald) + "              |              " + textBlack(locationBerge) + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Berge")) {
            outputMessage
                    .append(getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\n")
                    .append("Deine Karte:\n\n")
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlack(locationWueste) + "             |           " + textBlack(locationGruenland) + "            |           " + textBlue(locationWinterland) + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlack(locationStrand) + "             |              " + textBlue(locationWald) + "              |              " + textGreen(locationBerge) + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wueste")) {
            outputMessage
                    .append(getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\n")
                    .append("Deine Karte:\n\n")
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textGreen(locationWueste) + "             |           " + textBlue(locationGruenland) + "            |           " + textBlack(locationWinterland) + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlue(locationStrand) + "             |              " + textBlack(locationWald) + "              |              " + textBlack(locationBerge) + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Gruenland")) {
            outputMessage
                    .append(getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\n")
                    .append("Deine Karte:\n\n")
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlue(locationWueste) + "             |           " + textGreen(locationGruenland) + "            |           " + textBlue(locationWinterland) + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlack(locationStrand) + "             |              " + textBlue(locationWald) + "              |              " + textBlack(locationBerge) + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else {
            outputMessage
                    .append(getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\n")
                    .append("Deine Karte:\n\n")
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlack(locationWueste) + "             |           " + textBlue(locationGruenland) + "            |           " + textGreen(locationWinterland) + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + textBlack(locationStrand) + "             |              " + textBlack(locationWald) + "              |              " + textBlue(locationBerge) + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");
        }
        return outputMessage.toString();
    }

}
