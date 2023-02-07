package org.bitbiome.commands;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class QuizCommandTest {

    @Test
    public void testStartMessage() {
        assertTrue(QuizCommand.starterMessage().contains("Du hast das Quiz gestartet!"));
    }

    @Test
    public void testEndMessage() {
        assertTrue(QuizCommand.endMessage().contains("Das Quiz ist vorbei!"));
    }

    @Test
    public void testLastTimePlayed() {
        long lastTimePlayed = System.currentTimeMillis();
        assertTrue(QuizCommand.canPlayAgain(lastTimePlayed) < lastTimePlayed);
    }

    @Test
    public void testRandomNumberGenerator() {
        int getRandom = QuizCommand.random(3);
        assertTrue(getRandom >= 0 && getRandom <= 3);
    }

    @Test
    public void testPrintFunction() {
        assertEquals("I am a unit test!", QuizCommand.print("I am a unit test!"));
    }
}
