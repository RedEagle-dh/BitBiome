package org.bitbiome.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuitCommandTest {


    @Test
    public void testQuitCommand() {
        assertTrue(QuitCommand.getQuitMessage().contains("Spiel beendet!"));
    }

}
