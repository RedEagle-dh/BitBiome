package org.bitbiome.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuizCommandTest {

    @Test
    public void testStartMessage() {
        assertEquals("Du hast das Quiz gestartet! Hinweis: Wähle deine Antwort, indem du die Zahl (1-4) eingibst. Ist deine Lösung richtig, erhälst du 5 Münzen. Viel Erfolg! \n", QuizCommand.starterMessage());
    }

    @Test
    public void testEndMessage() {
        assertEquals("Das Quiz ist vorbei!", QuizCommand.endMessage());
    }

    @Test
    public void testLastTimePlayed() {
        long lastTimePlayed = System.currentTimeMillis();
        assertTrue(QuizCommand.canPlayAgain(lastTimePlayed) < lastTimePlayed);
    }
}