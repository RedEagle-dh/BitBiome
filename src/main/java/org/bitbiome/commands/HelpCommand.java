package org.bitbiome.commands;


import org.bitbiome.classes.Colors;
import org.bitbiome.classes.TravelEngine;


import java.util.Scanner;

public class HelpCommand implements CommandAPI {


    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getHelpMessage());
    }

    public static String getHelpMessage() {
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append("|______________|_____________________________|\n")
                .append("|" + Colors.ANSI_PURPLE + " Command" + Colors.ANSI_RESET + "      |       " + Colors.ANSI_PURPLE + "Description" + Colors.ANSI_RESET + "           |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " help" + Colors.ANSI_RESET + "         | Gibt diese Nachricht aus    |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " exit/quit" + Colors.ANSI_RESET + "    | Beendet das Spiel           |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " travel" + Colors.ANSI_RESET + "       | Startet das Reise System    |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " location" + Colors.ANSI_RESET + "     | Gibt deine Location aus     |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " quiz" + Colors.ANSI_RESET + "         | Startet das quiz im shop    |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " blackjack" + Colors.ANSI_RESET + "    | Startet blackjack im shop   |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " inventory" + Colors.ANSI_RESET + "    | Gibt dein Inventar aus        |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " collect " + Colors.ANSI_RESET + "     | Gibt deine Location aus       |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " lookaround" + Colors.ANSI_RESET + "   | Zeigt dir deine Umgebung,     |\n")
                .append("|" + Colors.ANSI_GREEN + "           " + Colors.ANSI_RESET + "   | Items und Mobs in der Nähe    |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " map" + Colors.ANSI_RESET + "          | Zeigt dir deinen Karte      |\n")
                .append("|--------------|-----------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " gold" + Colors.ANSI_RESET + "         | Gibt dein Gold an           |\n")
                .append("|______________|_____________________________|\n")
                .append("|" + Colors.ANSI_GREEN + " use" + Colors.ANSI_RESET + "          | Benutze ein Item            |\n")
                .append("|______________|_____________________________|\n")
                .append("|" + Colors.ANSI_GREEN + " runaway" + Colors.ANSI_RESET + "      | Fliehe aus einem Kampf      |\n")
                .append("|______________|_____________________________|\n");

        return outputMessage.toString();
    }

}
