package org.bitbiome.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.bitbiome.entities.Mob;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.Test;

public class UseCommandTest {
    public void testUseCommand() {
        testGetUseMessage();
    }

    @Test
    public void testGetUseMessage() {
        UseCommand com = new UseCommand();
        TravelEngine engine = new TravelEngine(new Player("test"));
        assertEquals("That item is not in your inventory.", com.getUseMessage("", engine));
        assertEquals("That item is not in your inventory.", com.getUseMessage("Fell", engine));
        engine.getPlayer().addToInventory(new Item("Fell", false, 0));
        assertEquals("You can't attack with this.", com.getUseMessage("Fell", engine));
        engine.getPlayer().addToInventory(new Item("Sword", true, 10));
        assertEquals("You used Sword on yourself", com.getUseMessage("Sword", engine));
        assertEquals("That target is not available.", com.getUseMessage("Sword on Wolf", engine));
        engine.getPlayer().getLocation().getMobList().add(new Mob("Wolf", false, 11, 10));
        assertEquals("You used Sword on Wolf", com.getUseMessage("Sword on Wolf", engine));
        assertEquals("You killed Wolf with Sword", com.getUseMessage("Sword on Wolf", engine));
        assertEquals("That target is not available.", com.getUseMessage("Sword on Wolf", engine));
        engine.getPlayer().addToInventory(new Item("Heiliges Schwert der Erzengel", true, 3000));
        assertEquals("You used Heiliges Schwert der Erzengel on yourself and died.", com.getUseMessage("Heiliges Schwert der Erzengel", engine));
    }
}