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
    private static String signup() {
        return (" __________________________________________________________________________________________________\n");
    }
    private static String signdown() {
        return ("|________________________________|________________________________|________________________________|\n");
    }
    private static String signmiddle() {
        return ("|                                |                                |                                |\n");
    }
    private static String mapup(TravelEngine travelEngine) {
        return getLocationMessage(travelEngine) + "Zu den " + textBlue("blau ") + "markierten Standorten kannst du reisen\n\nDeine Karte:\n\n" + signup() + signmiddle() + signmiddle();
    }
    private static String mapmiddle() {
        return signmiddle() + signdown() + signmiddle() + signmiddle();
    }
    private static String mapdown() {
        return signmiddle() + signdown();
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
                    .append(mapup(travelEngine))
                    .append("|             " + textBlack(locationWueste) + "             |           " + textBlue(locationGruenland) + "            |           " + textBlack(locationWinterland) + "           |" + "\n")
                    .append(mapmiddle())
                    .append("|             " + textBlue(locationStrand) + "             |              " + textGreen(locationWald) + "              |              " + textBlue(locationBerge) + "             |" + "\n")
                    .append(mapdown());
        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Strand")) {
            outputMessage
                    .append(mapup(travelEngine))
                    .append("|             " + textBlue(locationWueste) + "             |           " + textBlack(locationGruenland) + "            |           " + textBlack(locationWinterland) + "           |" + "\n")
                    .append(mapmiddle())
                    .append("|             " + textGreen(locationStrand) + "             |              " + textBlue(locationWald) + "              |              " + textBlack(locationBerge) + "             |" + "\n")
                    .append(mapdown());

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Berge")) {
            outputMessage
                    .append(mapup(travelEngine))
                    .append("|             " + textBlack(locationWueste) + "             |           " + textBlack(locationGruenland) + "            |           " + textBlue(locationWinterland) + "           |" + "\n")
                    .append(mapmiddle())
                    .append("|             " + textBlack(locationStrand) + "             |              " + textBlue(locationWald) + "              |              " + textGreen(locationBerge) + "             |" + "\n")
                    .append(mapdown());

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wueste")) {
            outputMessage
                    .append(mapup(travelEngine))
                    .append("|             " + textGreen(locationWueste) + "             |           " + textBlue(locationGruenland) + "            |           " + textBlack(locationWinterland) + "           |" + "\n")
                    .append(mapmiddle())
                    .append("|             " + textBlue(locationStrand) + "             |              " + textBlack(locationWald) + "              |              " + textBlack(locationBerge) + "             |" + "\n")
                    .append(mapdown());

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Gruenland")) {
            outputMessage
                    .append(mapup(travelEngine))
                    .append("|             " + textBlue(locationWueste) + "             |           " + textGreen(locationGruenland) + "            |           " + textBlue(locationWinterland) + "           |" + "\n")
                    .append(mapmiddle())
                    .append("|             " + textBlack(locationStrand) + "             |              " + textBlue(locationWald) + "              |              " + textBlack(locationBerge) + "             |" + "\n")
                    .append(mapdown());

        } else {
            outputMessage
                    .append(mapup(travelEngine))
                    .append("|             " + textBlack(locationWueste) + "             |           " + textBlue(locationGruenland) + "            |           " + textGreen(locationWinterland) + "           |" + "\n")
                    .append(mapmiddle())
                    .append("|             " + textBlack(locationStrand) + "             |              " + textBlack(locationWald) + "              |              " + textBlue(locationBerge) + "             |" + "\n")
                    .append(mapdown());
        }
        return outputMessage.toString();
    }

}
