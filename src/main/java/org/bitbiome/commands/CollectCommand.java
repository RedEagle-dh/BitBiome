package org.bitbiome.commands;

import org.bitbiome.classes.JsonParser;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {

    }

    public void collectItem(ArrayList<Item> location, String item, JsonParser jp, JSONObject o, JSONArray inventory, TravelEngine travelEngine) {
       
    }
}

