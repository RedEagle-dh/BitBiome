package org.bitbiome.commands;

import java.util.ArrayList;
import java.util.Scanner;

import org.bitbiome.classes.*;
import org.bitbiome.entities.*;

public class UseCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine engine) {
        do {
            System.out.println(getUseMessage(message.split(" ", 2)[1], engine));
            if(engine.getPlayer().getHp() <= 0)
                System.exit(0);
        } while(getNumOfEnemyMobs(engine) > 0);
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
                Location loc = player.getLocation();
                ArrayList<Mob> mobs = loc.getMobList();
                for(int j = 0; j<mobs.size(); j++) {
                    Mob mob = mobs.get(j);
                    if(mob.getName().equals(targetName))
                        return useItem(item, mob, loc);
                }
                return "That target is not available.";
            }
        }
        return "That item is not in your inventory.";
    }

    private String useItem(Item item, Player target) {
        float hp = target.getHp();
        hp -= item.getDamage();
        String retString = "You used " + item.getName() + " on yourself";
        if(hp <= 0) {
            target.setHp(0);
            return retString + " and died.";
        }
        target.setHp(hp);
        return retString;
    }

    private String useItem(Item item, Mob target, Location location) {
        float hp = target.getHp();
        float dmg = item.getDamage();
        if(dmg>=hp) {
            location.getMobList().remove(target);
            return "You killed " + target.getName() + " with " + item.getName();
        }
        target.setHp(hp-dmg);
        target.setFriendly(false);
        return "You used " + item.getName() + " on " + target.getName();
    }

    private int getNumOfEnemyMobs(TravelEngine engine) {
        Location loc = engine.getPlayer().getLocation();
        ArrayList<Mob> mobs = loc.getMobList();
        int count = 0;
        for(int i = 0; i<mobs.size(); i++) {
            Mob mob = mobs.get(i);
            if(!mob.isFriendly())
                count++;
        }
        return count;
    }
}