package org.bitbiome.commands;

import java.util.Scanner;

public class UseCommand implements CommandAPI {
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println(getUseMessage(message.split(" ", 2)[1]));
    }

    private String getUseMessage(String msg) {
        String message[] = msg.split(" on ");
        String returnString = "You used " + msg;
        if(message.length == 1)
            returnString+=" on yourself";
        return returnString;
    }
}