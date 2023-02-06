package org.bitbiome.commands;


import org.bitbiome.classes.BlackJack;

import java.util.Random;
import java.util.Scanner;

public class BlackJackCommand implements CommandAPI {
    private boolean over;
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {

        System.out.println("Du hast das Spiel BlackJack gestartet. Die Spielregeln lauten wie folgt: Du und dein Gegner bekommen jede Runde Zahlen von 4 - 11. \nDerjenige, der zuerst 21 Punkte hat gewinnt. Derjenige, der über 21 Punkte hat verliert. Möchte keiner mehr Karten ziehen, gewinnt der mit dem höchsten Blatt!\nViel Spaß!");

        over = false;
        spielen();
    }

    public void spielen() {
        BlackJack bj = new BlackJack("Dave");
        Scanner sc = new Scanner(System.in);
        BlackJack.Entity player = bj.getEntity(1);
        while (!over) {
            int r = new Random().nextInt(4, 11);
            bj.addPoints(player, r);
            System.out.println(bj.getPlayerName(player) + " hat " + r + " bekommen. Er hat insgesamt " + bj.getPoints(player) + ".");

            if (bj.getPoints(player) >= 21) {
                over21(player, bj);
                has21(player, bj);
                over = true;
                break;
            }
            System.out.print("Weiter?");

            if (player == BlackJack.Entity.BOT) {
                if (bj.botWantsToPlay()) {
                    System.out.println("Na klar!");
                } else {
                    System.out.println("Nope, ich bin fertig.");
                }
            } else {
                String eingabe = sc.nextLine();
                if (!eingabe.toLowerCase().startsWith("j")) {
                    bj.playerOut();
                }
            }


            player = switchPlayer(player, bj);

        }
    }

    public void over21(BlackJack.Entity player, BlackJack bj) {
        if (bj.getPoints(player) > 21) {
            over = true;
            System.out.println(bj.getPlayerName(player) + " hat über 21 Punkte und damit verloren.");
        }

    }


    public void has21(BlackJack.Entity player, BlackJack bj) {
        if (bj.getPoints(player) == 21) {
            System.out.println(bj.getPlayerName(player) + " hat gewonnen! Du hast 21 Punkte!");
            over = true;
        }
    }

    public BlackJack.Entity switchPlayer(BlackJack.Entity player, BlackJack bj) {
        BlackJack.Entity BOT = BlackJack.Entity.BOT;
        BlackJack.Entity PLAYER = BlackJack.Entity.PLAYER;
        if (bj.isIn(BOT) || bj.isIn(PLAYER)) {
            if (player == PLAYER) {
                if (bj.isIn(BOT)) {
                    return BOT;
                }
                return PLAYER;
            } else {
                if (bj.isIn(PLAYER)) {
                    return PLAYER;
                }
                return BOT;
            }
        } else {
            over = true;
            getWinner(bj);
            return null;
        }
    }


    public void getWinner(BlackJack bj) {
        BlackJack.Entity entity;
        if (bj.getPoints(BlackJack.Entity.BOT) < bj.getPoints(BlackJack.Entity.PLAYER)) {
            entity = BlackJack.Entity.PLAYER;
            System.out.println(bj.getPlayerName(entity) + " hat gewonnen, da er mehr Punkte hat!");
        } else if (bj.getPoints(BlackJack.Entity.BOT) == bj.getPoints(BlackJack.Entity.PLAYER)){
            System.out.println("Es ist Gleichstand!");
        } else {
            entity = BlackJack.Entity.BOT;
            System.out.println(bj.getPlayerName(entity) + " hat gewonnen, da er mehr Punkte hat!");
        }

    }
}