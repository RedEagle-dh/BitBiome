package org.bitbiome;

import java.util.Scanner;

public class InteractionLoop {

    Scanner input = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            String line = input.nextLine().toLowerCase();
            System.out.println(line);
        }
    }



}
