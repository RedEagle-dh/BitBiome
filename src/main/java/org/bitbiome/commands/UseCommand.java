package org.bitbiome.commands;

import java.util.ArrayList;
import java.util.Scanner;

import org.bitbiome.classes.*;
import org.bitbiome.entities.*;

public class UseCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine engine) {
        System.out.println(getUseMessage(message.split(" ", 2)[1], engine));
    }

    private String getUseMessage(String msg, TravelEngine engine) {
        Player player = engine.getPlayer();
        String message[] = msg.split(" on ");
        String itemName = message[0];
        ArrayList<Item> inv = player.getInventory();
        
        for(int i = 0; i<inv.size(); i++) {
            Item item = inv.get(i);
            if(item.getName().equals(itemName)) {
                if(item.doesDamage())
                    return "You can't attack with this.";
                if(message.length == 1)
                    return useItem(item, player);
                String targetName = message[1];
                ArrayList<Mob> mobs = player.getLocation().getMobList();
                for(int j = 0; j<mobs.size(); j++) {
                    Mob mob = mobs.get(j);
                    if(mob.getName().equals(targetName))
                        return useItem(item, mob);
                }
                return "That target is not available.";
            }
        }
        return "That item is not in your inventory.";
    }

    private String useItem(Item item, Player target) {
        return "You used " + item + " on " + target;
    }

    private String useItem(Item item, Mob target) {
        return "You used " + item + " on " + target;
    }
}