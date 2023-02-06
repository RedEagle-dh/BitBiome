package org.bitbiome.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuizCommandTest {

    @Test
    public void testStartMessage() {
        assertEquals("Du hast das Quiz gestartet! Hinweis: Wähle deine Antwort, indem du die Zahl (1-4) eingibst. Ist deine Lösung richtig, erhälst du 5 Münzen. Viel Erfolg! \n", QuizCommand.starterMessage());
    }

    @Test
    public void testEndMessage() {
        assertEquals("Das Quiz ist vorbei!", QuizCommand.endMessage());
    }
}
