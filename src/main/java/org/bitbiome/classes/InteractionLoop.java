package org.bitbiome.classes;

import org.bitbiome.Boot;

import java.util.Scanner;

public class InteractionLoop {

    Scanner input = new Scanner(System.in);

    public void run(TravelEngine travelEngine) {
        boolean isRunning = true;
        System.out.println("Willkommen zu BitBiome " + travelEngine.getPlayer().getName() + "!\n\n");
        while (isRunning) {
            String line = input.nextLine().toLowerCase();
            if (!Boot.instance.getCmdListener().perform(line.toLowerCase().split(" ")[0], input, isRunning, line, travelEngine)) {
                System.out.println("Unknown Command");
            }
        }
    }



}
