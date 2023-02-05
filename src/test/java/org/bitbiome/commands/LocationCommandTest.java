package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class LocationCommandTest {

    @Test
    public void testLocationCommand() {
        Player p = new Player("Unit");
        TravelEngine tE = new TravelEngine(p);
        String[] standorte = {"Wald", "Strand", "Berge", "Wueste", "Winterland", "Gruenland"};
        String locationMessage = LocationCommand.getLocationMessage(tE).split(": ")[1];
        assertTrue(Arrays.asList(standorte).contains(locationMessage));
    }

}
