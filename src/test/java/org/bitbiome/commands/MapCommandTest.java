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
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Wald" + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_GREEN + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BLUE + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
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
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Strand" + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BRIGHT_BLACK + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_GREEN + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
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
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Berge" + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BRIGHT_BLACK + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BLUE + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BLUE + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_GREEN + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
    @Test
    public void testWuesteMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Wueste = outputtest.getLocationByName("Wueste");
        outputtest.travelTo(Wueste);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Wueste" + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_GREEN + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BRIGHT_BLACK + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BRIGHT_BLACK + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
    @Test
    public void testGruenlandMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Gruenland = outputtest.getLocationByName("Gruenland");
        outputtest.travelTo(Gruenland);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Gruenland" + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BLUE + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_GREEN + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BLUE + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
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
    public void testWinterlandMapCommand() {
        Player Test = new Player("name");
        TravelEngine outputtest = new TravelEngine(Test);
        Location Winterland = outputtest.getLocationByName("Winterland");
        outputtest.travelTo(Winterland);
        String mapMessage = MapCommand.getMapMessage(outputtest);
        StringBuilder outputMessage = new StringBuilder();
        outputMessage
                .append(Colors.ANSI_BLUE + "Du befindest dich gerade hier: Winterland" + "\n" + Colors.ANSI_RESET + "Zu den " + Colors.ANSI_BLUE + "blau " + Colors.ANSI_RESET + "markierten Standorten kannst du reisen\n" + Colors.ANSI_RESET)
                .append(Colors.ANSI_BLUE + "Deine Karte:\n\n" + Colors.ANSI_RESET)
                .append(" __________________________________________________________________________________________________\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Wueste" + Colors.ANSI_RESET + "             |           " + Colors.ANSI_BLUE + "Gruenland" + Colors.ANSI_RESET + "            |           " + Colors.ANSI_BRIGHT_BLACK + "Winterland" + Colors.ANSI_RESET + "           |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n")
                .append("|                                |                                |                                |\n")
                .append("|                                |                                |                                |\n")
                .append("|             " + Colors.ANSI_BRIGHT_BLACK + "Strand" + Colors.ANSI_RESET + "             |              " + Colors.ANSI_BRIGHT_BLACK + "Wald" + Colors.ANSI_RESET + "              |              " + Colors.ANSI_BLUE + "Berge" + Colors.ANSI_RESET + "             |" + "\n")
                .append("|                                |                                |                                |\n")
                .append("|________________________________|________________________________|________________________________|\n");


        assertEquals(outputMessage.toString(), mapMessage);
    }
}

