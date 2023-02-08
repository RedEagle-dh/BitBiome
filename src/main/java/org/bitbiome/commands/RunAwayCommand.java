package org.bitbiome.commands;

import java.util.Scanner;

import org.bitbiome.classes.TravelEngine;

public class RunAwayCommand implements CommandAPI {

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        System.out.println(getRunAwayMessage());
    }

    public String getRunAwayMessage() {
        return "You can only run away when you're fighting someone.";
    }
    
}
