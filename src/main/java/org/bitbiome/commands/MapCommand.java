package org.bitbiome.commands;
import org.bitbiome.classes.TravelEngine;
import org.json.JSONArray;
import java.util.Scanner;

public class MapCommand implements CommandAPI{
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getMapMessage(travelEngine));
    }
    public static String getMapMessage(TravelEngine travelEngine) {
        StringBuilder outputMessage = new StringBuilder();
        JSONArray locations = travelEngine.getLocationList();
            outputMessage
                    .append("Map:\n")
                    .append(locations.getJSONObject(5).getString("name") + "         " + locations.getJSONObject(4).getString("name") + "       " + locations.getJSONObject(2).getString("name") + "\n\n")
                    .append(locations.getJSONObject(1).getString("name") + "         " + locations.getJSONObject(0).getString("name") + "            " + locations.getJSONObject(3).getString("name") + "\n\n");

        return outputMessage.toString();
    }

}
