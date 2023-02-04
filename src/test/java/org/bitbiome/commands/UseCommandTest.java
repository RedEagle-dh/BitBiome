package org.bitbiome.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.bitbiome.entities.Mob;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.Test;

public class UseCommandTest {
    @Test
    public void testGetRunawayChance() {
        UseCommand com = new UseCommand();
        assertEquals(10, com.getRunawayChance());
        ArrayList<Mob> enemies = new ArrayList<Mob>();
        enemies.add(new Mob("Wolf", false, 11, 10));
        com.getEnemies(enemies);
        assertEquals(17, com.getRunawayChance());
        enemies.add(new Mob("Drache", false, 55, 20));
        com.getEnemies(enemies);
        assertEquals(41, com.getRunawayChance());
        enemies.add(new Mob("Drache", false, 55, 20));
        enemies.add(new Mob("Drache", false, 55, 20));
        enemies.add(new Mob("Drache", false, 55, 20));
        enemies.add(new Mob("Drache", false, 55, 20));
        enemies.add(new Mob("Drache", false, 55, 20));
        com.getEnemies(enemies);
        assertEquals(96, com.getRunawayChance());
        enemies = new ArrayList<Mob>();
        enemies.add(new Mob("Cthulhu", false, 15000, 10000));
        com.getEnemies(enemies);
        assertEquals(100, com.getRunawayChance());
    }

    @Test
    public void testRunawaySucceeds() {
        UseCommand com = new UseCommand();
        assertEquals(true, com.runawaySucceeds(0));
        assertEquals(false, com.runawaySucceeds(101));
    }

    @Test
    public void testUseItemMob() {
        UseCommand com = new UseCommand();
        Player player = new Player("test");
        Mob mob = new Mob("Wolf", false, 11, 10);
        player.getLocation().getMobList().add(mob);
        Item sword = new Item("Sword", true, 10);
        assertEquals("You used Sword on Wolf", com.useItem(sword, mob, player.getLocation()));
        assertEquals(1, player.getLocation().getMobList().size());
        assertEquals("You killed Wolf with Sword", com.useItem(sword, mob, player.getLocation()));
        assertEquals(0, player.getLocation().getMobList().size());
    }

    @Test
    public void testUseItemPlayer() {
        UseCommand com = new UseCommand();
        Player player = new Player("test");
        Item sword = new Item("Sword", true, 10);
        assertEquals("You used Sword on yourself", com.useItem(sword, player));
        assertEquals(90, player.getHp());
        Item sword2 = new Item("Heiliges Schwert der Engel", true, 1000);
        assertEquals("You used Heiliges Schwert der Engel on yourself and died.", com.useItem(sword2, player));
    }

    @Test
    public void testGetUseMessage() {
        UseCommand com = new UseCommand();
        TravelEngine engine = new TravelEngine(new Player("test"));
        assertEquals("That item is not in your inventory.", com.getUseMessage("", engine));
        assertEquals("That item is not in your inventory.", com.getUseMessage("Fell", engine));
        engine.getPlayer().addToInventory(new Item("Fell", false, 0));
        assertEquals("You can't attack with this.", com.getUseMessage("Fell", engine));
        engine.getPlayer().addToInventory(new Item("Heiliges Schwert der Erzengel", true, 3000));
        assertEquals("That target is not available.", com.getUseMessage("Heiliges Schwert der Erzengel on Wolf", engine));
        assertEquals("That target is not available.", com.getUseMessage("hEiLiGeS sChWeRt DeR eRzEnGeL on WoLf", engine));
        engine.getPlayer().getLocation().getMobList().add(new Mob("Wolf", false, 11, 10));
        assertEquals("You killed Wolf with Heiliges Schwert der Erzengel", com.getUseMessage("Heiliges Schwert der Erzengel on Wolf", engine));
        assertEquals("That target is not available.", com.getUseMessage("Heiliges Schwert der Erzengel on Wolf", engine));
        engine.getPlayer().getLocation().getMobList().add(new Mob("Wolf", false, 11, 10));
        assertEquals("You killed Wolf with Heiliges Schwert der Erzengel", com.getUseMessage("hEiLiGeS sChWeRt DeR eRzEnGeL on WoLf", engine));
    }
}
