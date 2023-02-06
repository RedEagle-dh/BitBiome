package org.bitbiome.commands;


import java.util.Scanner;

public class BlackJackCommand implements CommandAPI {

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println("Du hast das Spiel BlackJack gestartet. Die Spielregeln lauten wie folgt: Du und dein Gegner bekommen jede Runde Zahlen von 4 - 11. \nDerjenige, der zuerst 21 Punkte hat gewinnt. Derjenige, der über 21 Punkte hat verliert. Möchte keiner mehr Karten ziehen, gewinnt der mit dem höchsten Blatt!\n");
    }
}