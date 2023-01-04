package org.bitbiome.commands;

import java.util.Scanner;

public interface CommandAPI {
    public void performCommand(Scanner scanner, boolean isRunning, String message);

}
