package org.bitbiome.commands;

import java.util.Scanner;

public class UseCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println(getUseMessage(message.split(" ", 2)[1]));
    }

    private String getUseMessage(String msg) {
        String item = getItemName(msg);
        String target = msg.replaceFirst(item + " on ", "");
        return useItem(item, target);
    }

    private String useItem(String item, String target) {
        return "You used " + item + " on " + target;
    }

    private String getItemName(String msg) {
        return "";
    }
}