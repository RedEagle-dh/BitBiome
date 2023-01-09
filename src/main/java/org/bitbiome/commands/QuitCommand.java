package org.bitbiome.commands;

import java.util.Scanner;

public class QuitCommand implements CommandAPI {

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println(getQuitMessage());
        System.exit(0);
    }

    public static String getQuitMessage() {
        return "You quitted!";
    }
}
