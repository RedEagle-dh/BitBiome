package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.bitbiome.classes.TravelEngine;

import java.util.Scanner;

public class QuitCommand implements CommandAPI {

    // This command is used to end the game via command
    // When the player quits the game, the game is stopped through System.exit(0)
    // That means it is exited with no error status
    
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getQuitMessage());
        System.exit(0);
    }

    public static String getQuitMessage() {
        return Colors.ANSI_BG_GREEN + "Du hast das Spiel beendet! Bis bald." + Colors.ANSI_RESET;
    }
}
