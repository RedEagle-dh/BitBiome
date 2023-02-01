package org.bitbiome.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapCommandTest {
    @Test
    public void testMapCommand() {
        String mapMessage = MapCommand.getMapMessage();
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append("Map:\n")
                .append("Wueste         Gruendland      Winterland\n\n")
                .append("Strand         Wald            Berge\n\n");
        assertEquals(outputMessage.toString(), mapMessage);
    }
}
