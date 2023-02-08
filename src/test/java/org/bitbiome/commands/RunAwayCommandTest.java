package org.bitbiome.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RunAwayCommandTest {
    @Test
    public void testRunAwayCommand() {
        assertEquals("You can only run away when you're fighting someone.", new RunAwayCommand().getRunAwayMessage());
    }
}
