package org.bitbiome.commands;

import org.bitbiome.classes.Colors;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryCommandTest {
    @Test
    public void testInventoryCommand(){
        InventoryCommand command = new InventoryCommand();
        Player p = new Player("Unit");
        TravelEngine travelEngine = new TravelEngine(p);
        ArrayList<Item> inventory = new ArrayList<>();
        Item item1 = new Item("Holz", false, 0,5);
        Item item2 = new Item("Stein", true, 10, 5);
        inventory.add(item1);
        inventory.add(item2);
        travelEngine.getPlayer().setInventory(inventory);

        String expectedResult = Colors.ANSI_BRIGHT_RED + "Du möchtest wissen, was in deinem Inventar ist? \n" +
                "Dann lass uns gemeinsam deinen Rucksack öffnen. \nDein Rucksack steckt ja voller Überraschungen! \n" +
                "Das hast du alles schon gefunden: \n" + Colors.ANSI_RESET +
                Colors.ANSI_BRIGHT_BG_RED + Colors.ANSI_BRIGHT_WHITE + "- " + "Holz" + " x" + 5 + "  " + Colors.ANSI_RESET + "\n" +
                Colors.ANSI_BRIGHT_BG_RED + Colors.ANSI_BRIGHT_WHITE + "- " + "Stein" + " x" + 5 + "  " + Colors.ANSI_RESET + "\n";

        String result = command.readInv(travelEngine);
        assertEquals(expectedResult, result);
    }

    }

    //was ist, wenn ich mehr im inventar habe?, wie kann ich den anpassen auf den jeweiligen spielstand?

