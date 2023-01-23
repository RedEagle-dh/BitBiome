package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelpCommandTest {

    @Test
    public void testHelpCommand() {
        String helpMessage = HelpCommand.getHelpMessage();
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
                .append("|______________|_____________________________|\n");
        assertEquals(outputMessage.toString(), helpMessage);
    }


}
