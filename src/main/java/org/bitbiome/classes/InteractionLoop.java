package org.bitbiome.classes;

import org.bitbiome.Boot;
import org.json.JSONObject;
import java.util.Scanner;


public class InteractionLoop {

    Scanner input = new Scanner(System.in);

    public void run(TravelEngine travelEngine) {
        boolean isRunning = true;
        if (travelEngine.getPlayer().getName().equals("null")) {
            print(Colors.ANSI_BLUE + "Oh, ein Fremder!\nBist du bereit für dein womöglich größtes Abenteuer?\nDann sag mir doch zunächst wie du heißt: " + Colors.ANSI_RESET);
            String name = input.nextLine();
            JsonParser jp = new JsonParser();
            JSONObject playerconf = jp.getJSONObject("playerconfig.json");
            playerconf.put("name", name);
            travelEngine.getPlayer().setName(name);
            jp.writeObject("playerconfig.json", playerconf);
        }
        print(Colors.ANSI_BG_CYAN + Colors.ANSI_BLACK + "Willkommen zu BitBiome " + travelEngine.getPlayer().getName() + "!" + Colors.ANSI_RESET + "\n\n");
        while (isRunning) {
            String line = input.nextLine().toLowerCase();
            if (!Boot.instance.getCmdListener().perform(line.toLowerCase().split(" ")[0], input, isRunning, line, travelEngine)) {
                print(Colors.ANSI_RED + "Unbekannter Befehl - Siehe " + Colors.ANSI_PURPLE + "help\n" + Colors.ANSI_RESET);
            }
        }
    }

    public boolean print(String message) {
        System.out.println(message);
        return true;
    }



}
