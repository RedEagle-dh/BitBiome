package org.bitbiome.commands;

import org.bitbiome.classes.TravelEngine;

import java.util.Scanner;

public interface CommandAPI {
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine);

}
