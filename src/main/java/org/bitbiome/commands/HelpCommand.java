package org.bitbiome.commands;

import org.bitbiome.Boot;

import java.util.HashMap;
import java.util.Scanner;

public class HelpCommand implements CommandAPI {


    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        HashMap<String, CommandAPI> commands = Boot.instance.getCmdListener().returnCommands();
        StringBuilder outputMessage = new StringBuilder();
        outputMessage.append("Hier ist eine Liste der Commands:\n");
        commands.forEach((key, value) -> {
            outputMessage.append("- ").append(key).append("\n");
        });
        System.out.println(outputMessage.toString());
    }

}
