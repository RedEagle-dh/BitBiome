package org.bitbiome.commands;

import java.util.Scanner;

public class QuitCommand implements CommandAPI {

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println("You quitted!");
        System.exit(0);
    }
}
