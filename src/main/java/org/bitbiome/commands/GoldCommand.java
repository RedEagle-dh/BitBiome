package org.bitbiome.commands;

import java.util.Scanner;

import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Player;




public class GoldCommand implements CommandAPI{


    public static String getGoldMessage(Player player) {
        return "Du hast " + player.getGold() + " Gold";
    }

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getGoldMessage(travelEngine.getPlayer()));
        return;
    }
}
