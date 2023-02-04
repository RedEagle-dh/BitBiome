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
                System.out.println(mob.getName() + " hat dich angegriffen und " + mob.getDamage() + " Schaden zugefügt.");
                if(hp <= 0) {
                    player.setHp(0);
                    System.out.println("Du bist gestorben.");
                    System.exit(0);
                }
                player.setHp(hp);
            }
            COMBAT_LOOP:do {
                System.out.println("Was willst du tun?");
                String input = scanner.nextLine();
                switch(input) {
                    case "use":
                        System.out.println(use(scanner, engine));
                        break COMBAT_LOOP;
                    case "runaway":
                        if(runawaySucceeds(getRunawayChance())) {
                            System.out.println("Du bist erfolgreich geflüchtet.");
                            combat = false;
                            break COMBAT_LOOP;
                        }
                        System.out.println("Dein Fluchtversuch ist fehlgeschlagen.");
                        break;
                    case "help":
                        new HelpCommand().performCommand(scanner, true, "", engine);
                        break;
                    case "exit":
                    case "quit":
                        System.out.println("Du kannst nicht während eines Kampfes das Spiel verlassen.");
                        break;
                    case "location":
                        new LocationCommand().performCommand(scanner, true, "", engine);
                        break;
                    case "travel":
                        System.out.println("Du kannst nicht während eines Kampfes reisen.");
                        break;
                    default:
                        System.out.println("Unbekannter Befehl - Siehe " + Colors.ANSI_PURPLE + "help" + Colors.ANSI_RESET);
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
        System.out.println("Welches Item willst du benutzen?");
        String item = scanner.nextLine();
        System.out.println("Auf welchen Gegner willst du es benutzen? (Leer lassen, um es auf dich selbst anzuwenden)");
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
                    return "Damit kannst du nicht angreifen.";
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
                return "Dieses Ziel ist nicht verfügbar.";
            }
        }
        return "Du bist nicht im Besitz dieses Items.";
    }

    public String useItem(Item item, Player target) {
        float hp = target.getHp();
        hp -= item.getDamage();
        String retString = "Du hast " + item.getName() + " auf dich selbst angewandt";
        if(hp <= 0) {
            target.setHp(0);
            return retString + " und bist gestorben.";
        }
        target.setHp(hp);
        return retString + ".";
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
            return "Du hast " + target.getName() + " mit " + item.getName() + " getötet.";
        }
        target.setHp(hp-dmg);
        target.setFriendly(false);
        return "Du hast " + item.getName() + " auf " + target.getName() + " angewandt.";
    }

    public void getEnemies(ArrayList<Mob> allMobs) {
        for(int i = 0; i<allMobs.size(); i++) {
            Mob mob = allMobs.get(i);
            if(!mob.isFriendly())
                enemies.add(mob);
        }
    }
}
