package org.bitbiome.commands;

import org.bitbiome.shop.Shop;

import java.util.Scanner;

public class ShopCommand implements CommandAPI{
    Shop shop = new Shop();

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println("Willkommen im Shop!");
        System.out.println("Folgende Items sind aktuell im Shop:");
        shop.printCurrentShopItems();
        System.out.println("Was willst Du hier im Shop?");
        System.out.println("Etwas kaufen: 1");
        System.out.println("Das Quiz spielen: 2");
        System.out.println("Den Shop verlassen: 3");

        while (true){
            String input = scanner.nextLine();
            if(validInput(input)){
                if(input.equals("1")){
                    //shop.buy();
                } else if(input.equals("2")){
                    //shop.quiz()
                } else if(input.equals("3")){
                    System.out.println("Der Shop wurde verlassen!");
                    break;
                }
            }else {
                System.out.println("Unbekannte Eingabe!");
            }
        }
    }

    public static boolean validInput(String input){
        return (input.equals("1") || input.equals("2") || input.equals("3"));
    }

}
