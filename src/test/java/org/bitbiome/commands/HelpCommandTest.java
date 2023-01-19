package org.bitbiome.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpCommandTest {

    @Test
    public void testHelpCommand() {
        String helpMessage = HelpCommand.getHelpMessage();
        assertEquals("Hier ist eine Liste der Commands:\n- help -> Gibt diese Nachricht aus\n- exit/quit -> Beendet das Spiel\n", helpMessage);
    }


}
