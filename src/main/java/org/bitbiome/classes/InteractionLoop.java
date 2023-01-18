package org.bitbiome.classes;

import org.bitbiome.Boot;

import java.util.Scanner;

public class InteractionLoop {

    Scanner input = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            String line = input.nextLine().toLowerCase();
            if (!Boot.instance.getCmdListener().perform(line.toLowerCase().split(" ")[0], input, isRunning, line)) {
                System.out.println("Unknown Command");
            }
        }
    }



}
