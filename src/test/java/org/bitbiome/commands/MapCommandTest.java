package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapCommandTest {
    @Test
    public void testMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append("Map:\n")
                .append("Wueste         Gruenland       Winterland\n\n")
                .append("Strand         Wald            Berge\n\n");
        assertEquals(outputMessage.toString(), mapMessage);
    }
}
