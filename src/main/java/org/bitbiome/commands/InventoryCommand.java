package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.bitbiome.classes.JsonParser;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {

        System.out.println(readInv(travelEngine));
    }

    public String readInv(TravelEngine travelEngine) {
        StringBuilder s = new StringBuilder();

        ArrayList<Item> inventory = travelEngine.getPlayer().getInventory();
        s.append(Colors.ANSI_PURPLE +"Du möchtest wissen, was in deinem Inventar ist? \n" +
                "Dann lass uns gemeinsam deinen Rucksack öffnen. \nDein Rucksack steckt ja voller Überraschungen! \n" +
                "Das hast du alles schon gefunden: \n"+ Colors.ANSI_RESET);
        for (int i=0; i < inventory.size(); i++){
            s.append(Colors.ANSI_BG_PURPLE+ Colors.ANSI_BRIGHT_WHITE+ "- ").append(inventory.get(i).getName()).append(" x").append(inventory.get(i).getAmount()).append("  "+ Colors.ANSI_RESET + "\n" );
        }

        return s.toString();
    }
}