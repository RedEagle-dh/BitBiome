package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;

import java.util.Scanner;

public interface CommandAPI {

    // This is the command interface. Every command implements it's run method from here
    // This is the API between the commands and the interaction loop/game    

    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine);

}
