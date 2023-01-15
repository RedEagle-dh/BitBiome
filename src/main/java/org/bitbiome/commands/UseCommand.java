package org.bitbiome.commands;

import java.util.Scanner;

public class UseCommand implements CommandAPI {
    private String getUseMessage(String msg) {
        return "";
    }

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println(getUseMessage(message.split(" ", 2)[1]));
    }
}
