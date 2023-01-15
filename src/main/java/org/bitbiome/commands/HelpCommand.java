package org.bitbiome.commands;

import java.util.Scanner;

public class HelpCommand implements CommandAPI {


    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println(getHelpMessage());
    }

    public static String getHelpMessage() {
        StringBuilder outputMessage = new StringBuilder();
        outputMessage.append("Hier ist eine Liste der Commands:\n").append("- help -> Gibt diese Nachricht aus\n").append("- exit/quit -> Beendet das Spiel\n");

        return outputMessage.toString();
    }

}
