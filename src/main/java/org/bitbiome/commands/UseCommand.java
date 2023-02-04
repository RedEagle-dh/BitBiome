package org.bitbiome.commands;

import java.util.ArrayList;
import java.util.Scanner;

import org.bitbiome.classes.*;
import org.bitbiome.entities.*;

public class UseCommand implements CommandAPI {
private ArrayList<Mob> enemies = new ArrayList<Mob>();
private boolean combat = false;

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine engine) {
        Player player = engine.getPlayer();
        getEnemies(player.getLocation().getMobList());
        System.out.println(use(scanner, engine));
        while(enemies.size() > 0 && combat) {
            combat(player, scanner, engine);
        }
    }

    public void combat(Player player, Scanner scanner, TravelEngine engine) {
        if(player.getHp() <= 0)
                System.exit(0);
            for(int i = 0; i<enemies.size(); i++) {
                Mob mob = enemies.get(i);
                float hp = player.getHp();
                hp -= mob.getDamage();
                System.out.println(mob.getName() + " attacked you for " + mob.getDamage() + " damage.");
                if(hp <= 0) {
                    player.setHp(0);
                    System.out.println("You died.");
                    System.exit(0);
                }
                player.setHp(hp);
            }
            COMBAT_LOOP:do {
                System.out.println("What do you want to do?");
                String input = scanner.nextLine();
                switch(input) {
                    case "use":
                        System.out.println(use(scanner, engine));
                        break COMBAT_LOOP;
                    case "runaway":
                        if(runawaySucceeds(getRunawayChance())) {
                            combat = false;
                            break COMBAT_LOOP;
                        }
                        break;
                    case "help":
                        new HelpCommand().performCommand(scanner, true, "", engine);
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("You cannot quit while in combat.");
                        break;
                    case "location":
                        new LocationCommand().performCommand(scanner, true, "", engine);
                        break;
                    case "travel":
                        System.out.println("You cannot travel while in combat.");
                        break;
                    default:
                        System.out.println("That is not a valid command.");
                        break;
                }
            } while(true);
    }

    public boolean runawaySucceeds(int chance) {
        int random = (int)(Math.random()*100);
        if(random >= chance)
            return true;
        return false;
    }

    public int getRunawayChance() {
        int chance = 10;
        for(int i = 0; i<enemies.size(); i++) {
            Mob mob = enemies.get(i);
            chance += (int)Math.round(Math.sqrt(mob.getHp() * mob.getDamage() / 3) * (110-chance) / 100) + 1;
        }
        if(chance > 100)
            chance = 100;
        return chance;
    }

    public String use(Scanner scanner, TravelEngine engine) {
        System.out.println("Which item would you like to use?");
        String item = scanner.nextLine();
        System.out.println("On who? (leave blank for self)");
        String target = scanner.nextLine();
        if(target.equals(""))
            return getUseMessage(item, engine);
        else
            return getUseMessage(item + " on " + target, engine);
    }

    public String getUseMessage(String msg, TravelEngine engine) {
        Player player = engine.getPlayer();
        String message[] = msg.split(" on ");
        String itemName = message[0];
        ArrayList<Item> inv = player.getInventory();
        
        for(int i = 0; i<inv.size(); i++) {
            Item item = inv.get(i);
            if(item.getName().toLowerCase().equals(itemName.toLowerCase())) {
                if(!item.doesDamage())
                    return "You can't attack with this.";
                if(message.length == 1)
                    return useItem(item, player);
                String targetName = message[1];
                Location loc = player.getLocation();
                ArrayList<Mob> mobs = loc.getMobList();
                for(int j = 0; j<mobs.size(); j++) {
                    Mob mob = mobs.get(j);
                    if(mob.getName().toLowerCase().equals(targetName.toLowerCase()))
                        return useItem(item, mob, loc);
                }
                return "That target is not available.";
            }
        }
        return "That item is not in your inventory.";
    }

    public String useItem(Item item, Player target) {
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

    public String useItem(Item item, Mob target, Location location) {
        combat = true;
        if(target.isFriendly())
            enemies.add(target);
        float hp = target.getHp();
        float dmg = item.getDamage();
        if(dmg>=hp) {
            location.getMobList().remove(target);
            enemies.remove(target);
            return "You killed " + target.getName() + " with " + item.getName();
        }
        target.setHp(hp-dmg);
        target.setFriendly(false);
        return "You used " + item.getName() + " on " + target.getName();
    }

    public void getEnemies(ArrayList<Mob> allMobs) {
        for(int i = 0; i<allMobs.size(); i++) {
            Mob mob = allMobs.get(i);
            if(!mob.isFriendly())
                enemies.add(mob);
        }
    }
}
