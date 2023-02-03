package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
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
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Wald" + "\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BLUE + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BLUE + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
}
