package org.bitbiome.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HelpCommandTest {

    @Test
    public void testHelpCommand() {
        String helpMessage = HelpCommand.getHelpMessage();
        assertTrue(helpMessage.contains("Command") && helpMessage.contains("Description"));
    }


}
