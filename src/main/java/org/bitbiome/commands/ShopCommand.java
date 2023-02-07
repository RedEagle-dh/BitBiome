package org.bitbiome.commands;

import org.bitbiome.classes.BlackJack;
import org.bitbiome.classes.Colors;
import org.bitbiome.classes.Shop;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.entities.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopCommand implements CommandAPI{

    Shop shop;
    BlackJack blackJack;
    public ShopCommand(){

    }

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        shop = new Shop(scanner, isRunning, message, travelEngine);
        blackJack = new BlackJack(travelEngine.getPlayer().getName());
        System.out.println(Colors.ANSI_BG_YELLOW + Colors.ANSI_BLACK + "Willkommen im Shop!" + Colors.ANSI_RESET);
        ArrayList<Item> currentItems = shop.loadCurrentShopItems();

        //whileloop for userinputs in the shop
        while (true){
            System.out.println("Was willst Du hier im Shop?");
            System.out.println("Etwas kaufen: 1");
            System.out.println("Das Quiz spielen: 2");
            System.out.println("Blackjack spielen: 3");
            System.out.println("Den Shop verlassen: 4");

            String input = scanner.nextLine();
            if(validInput(input)){
                if(input.equals("1")){
                    System.out.println("Folgende Items sind im Shop: ");
                    for(int i = 0; i < currentItems.size(); i++){
                        System.out.println((i + 1) + ". " + currentItems.get(i).getName() + " | Anzahl: " + currentItems.get(i).getAmount() + " | Gold: " + currentItems.get(i).getGold());
                    }
                    System.out.println("0 Eingeben um den Shop zu verlassen.");
                    System.out.println("");
                    System.out.print("Welches Item moechtest du kaufen? ");
                    String itemNumber = scanner.nextLine();
                    if(!itemNumber.equals("0")) {
                        System.out.print("Anzahl eingeben: ");
                        String amount = scanner.nextLine();
                        try {
                            if ((Integer.parseInt(amount) <= currentItems.get(Integer.parseInt(itemNumber) - 1).getAmount()) && ((Integer.parseInt(amount) - 1) > -1)) {
                                boolean bool = shop.buy(currentItems.get(Integer.parseInt(itemNumber) - 1).getName(), Integer.parseInt(amount));
                                currentItems = shop.loadCurrentShopItems();
                                if (bool) {
                                    System.out.println("");
                                    System.out.println(Colors.ANSI_BG_GREEN + Colors.ANSI_BLACK + "Vielen Dank für Ihren Einkauf!" + Colors.ANSI_RESET);
                                    System.out.println("");
                                } else {
                                    System.out.println(Colors.ANSI_BG_RED + Colors.ANSI_BLACK + "Fehler!" + Colors.ANSI_RESET);
                                }
                            } else {
                                System.out.println(Colors.ANSI_BG_RED + Colors.ANSI_BLACK + "Fehler!" + Colors.ANSI_RESET);
                            }
                        }catch (Exception e){
                            System.out.println(Colors.ANSI_BG_RED + Colors.ANSI_BLACK + "Fehler!" + Colors.ANSI_RESET);
                        }
                    }
                } else if(input.equals("2")){
                    shop.quiz();
                } else if(input.equals("3")){
                    shop.blackJack();
                }else if(input.equals("4")){
                    System.out.println("Der Shop wurde verlassen!");
                    break;
                }
            }else {
                System.out.println("Unbekannte Eingabe!");
            }
        }
    }

    public static boolean validInput(String input){
        return (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4"));
    }

}
