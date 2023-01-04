package org.bitbiome.commands;

import java.util.HashMap;
import java.util.Scanner;

public class CommandListener {

    private HashMap<String, CommandAPI> commands;

    public CommandListener() {
        commands = new HashMap<>();

        commands.put("help", new HelpCommand());

        commands.put("exit", new QuitCommand());
        commands.put("quit", new QuitCommand());
    }

    public HashMap<String, CommandAPI> returnCommands() {
        return commands;
    }


    public boolean perform(String command, Scanner scanner, boolean isRunning, String message) {

        CommandAPI cmd;
        if ((cmd = commands.get(command)) != null) {
            cmd.performCommand(scanner, isRunning, message);
            return true;
        }
        return false;
    }


}
