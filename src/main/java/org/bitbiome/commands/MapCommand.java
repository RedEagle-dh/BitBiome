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
        return "Du befindest dich gerade hier: " + travelEngine.getPlayer().getLocation().getName();
    }
    public static String getMapMessage(TravelEngine travelEngine) {
        StringBuilder outputMessage = new StringBuilder();
        JSONArray locations = travelEngine.getLocationList();
        String locationWueste = locations.getJSONObject(5).getString("name");
        String locationGruenland = locations.getJSONObject(4).getString("name");
        String locationWinterland = locations.getJSONObject(2).getString("name");
        String locationStrand = locations.getJSONObject(1).getString("name");
        String locationWald = locations.getJSONObject(0).getString("name");
        if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wald")) {
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BRIGHT_BLACK + locationWueste + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + locationGruenland + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + locationWinterland + Colors.ANSI_RESET + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BLUE + locationStrand + Colors.ANSI_RESET + "             |              " + Colors.ANSI_GREEN + locationWald + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BLUE + locations.getJSONObject(3).getString("name") + Colors.ANSI_RESET + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");
        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Strand")) {
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BLUE + locationWueste + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BRIGHT_BLACK + locationGruenland + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + locationWinterland + Colors.ANSI_RESET + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_GREEN + locationStrand + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + locationWald + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + locations.getJSONObject(3).getString("name") + Colors.ANSI_RESET + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Berge")) {
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BRIGHT_BLACK + locationWueste + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BRIGHT_BLACK + locationGruenland + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BLUE + locationWinterland + Colors.ANSI_RESET + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BRIGHT_BLACK + locationStrand + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + locationWald + Colors.ANSI_RESET + "              |              " + Colors.ANSI_GREEN + locations.getJSONObject(3).getString("name") + Colors.ANSI_RESET + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Wueste")) {
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_GREEN + locationWueste + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + locationGruenland + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + locationWinterland + Colors.ANSI_RESET + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BLUE + locationStrand + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BRIGHT_BLACK + locationWald + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + locations.getJSONObject(3).getString("name") + Colors.ANSI_RESET + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else if (travelEngine.getPlayer().getLocation().getName().equalsIgnoreCase("Gruenland")) {
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BLUE + locationWueste + Colors.ANSI_RESET + "             |           " + Colors.ANSI_GREEN + locationGruenland + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BLUE + locationWinterland + Colors.ANSI_RESET + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BRIGHT_BLACK + locationStrand + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + locationWald + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + locations.getJSONObject(3).getString("name") + Colors.ANSI_RESET + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");

        } else {
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                    .append(" __________________________________________________________________________________________________\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BRIGHT_BLACK + locationWueste + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + locationGruenland + Colors.ANSI_RESET + "            |           " + Colors.ANSI_GREEN + locationWinterland + Colors.ANSI_RESET + "           |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n")
                    .append("|                                |                                |                                |\n")
                    .append("|                                |                                |                                |\n")
                    .append("|             " + Colors.ANSI_BRIGHT_BLACK + locationStrand + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BRIGHT_BLACK + locationWald + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BLUE + locations.getJSONObject(3).getString("name") + Colors.ANSI_RESET + "             |" + "\n")
                    .append("|                                |                                |                                |\n")
                    .append("|________________________________|________________________________|________________________________|\n");
        }
        return outputMessage.toString();
    }

}
