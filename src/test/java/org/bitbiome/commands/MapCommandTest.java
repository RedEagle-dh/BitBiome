package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Location;
import org.bitbiome.entities.Mob;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class MapCommandTest {
    @Test
    public void testWaldMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Wald = outputtest.getLocationByName("Wald");
        outputtest.travelTo(Wald);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Wald" + "\n" + "Zu den blau markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BRIGHT_BLACK + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BLUE + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
    @Test
    public void testStrandMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Strand = outputtest.getLocationByName("Strand");
        outputtest.travelTo(Strand);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Strand" + "\n" + "Zu den blau markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BRIGHT_BLACK + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
    @Test
    public void testBergeMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Berge = outputtest.getLocationByName("Berge");
        outputtest.travelTo(Berge);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Berge" + "\n" + "Zu den blau markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BRIGHT_BLACK + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BLUE + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
    @Test
    public void testMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Winter = outputtest.getLocationByName("Winterland");
        outputtest.travelTo(Winter);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Winterland" + "\n" + Colors.ANSI_RESET)
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

