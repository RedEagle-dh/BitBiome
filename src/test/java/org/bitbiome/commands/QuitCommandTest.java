package org.bitbiome.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuitCommandTest {


    @Test
    public void testQuitCommand() {
        assertEquals("You quitted!", QuitCommand.getQuitMessage());
    }

}
