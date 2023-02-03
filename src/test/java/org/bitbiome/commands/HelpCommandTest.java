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
                .append("|______________|_______________________________|\n")
                .append("|" + Colors.ANSI_PURPLE + " Command" + Colors.ANSI_RESET + "      |       " + Colors.ANSI_PURPLE + "Description" + Colors.ANSI_RESET + "             |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " help" + Colors.ANSI_RESET + "         | Gibt diese Nachricht aus      |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " exit/quit" + Colors.ANSI_RESET + "    | Beendet das Spiel             |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " travel" + Colors.ANSI_RESET + "       | Startet das Reise System      |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " location" + Colors.ANSI_RESET + "     | Gibt deine Location aus       |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " inventory" + Colors.ANSI_RESET + "    | Gibt dein Inventar aus        |\n")
                .append("|--------------|-------------------------------|\n")
                .append("|" + Colors.ANSI_GREEN + " lookaround" + Colors.ANSI_RESET + "   | Zeigt dir deine Umgebung,     |\n")
                .append("|" + Colors.ANSI_GREEN + "           " + Colors.ANSI_RESET + "   | Items und Mobs in der Nähe    |\n")
                .append("|______________|_______________________________|\n");
        assertEquals(outputMessage.toString(), helpMessage);
    }


}
