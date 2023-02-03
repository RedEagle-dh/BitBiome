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
            outputMessage
                    .append(Colors.ANSI_BLUE + getLocationMessage(travelEngine) + "\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + "Deine Karte:\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + locations.getJSONObject(5).getString("name") + "         " + locations.getJSONObject(4).getString("name") + "         " + locations.getJSONObject(2).getString("name") + "\n\n" + Colors.ANSI_RESET)
                    .append(Colors.ANSI_BLUE + locations.getJSONObject(1).getString("name") + "         " + locations.getJSONObject(0).getString("name") + "         " + locations.getJSONObject(3).getString("name") + "\n\n" + Colors.ANSI_RESET);

        return outputMessage.toString();
    }

}
