package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;

import java.util.HashMap;
import java.util.Scanner;

public class CommandListener {

    private HashMap<String, CommandAPI> commands;

    public CommandListener() {
        commands = new HashMap<>();

        commands.put("help", new HelpCommand());

        commands.put("exit", new QuitCommand());
        commands.put("quit", new QuitCommand());

        commands.put("use", new UseCommand());
        commands.put("location", new LocationCommand());
        commands.put("travel", new TravelCommand());
    }

    public HashMap<String, CommandAPI> returnCommands() {
        return commands;
    }


    public boolean perform(String command, Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {

        CommandAPI cmd;
        if ((cmd = commands.get(command)) != null) {
            cmd.performCommand(scanner, isRunning, message, travelEngine);
            return true;
        }
        return false;
    }


}
