package org.bitbiome.commands;

import org.bitbiome.shop.Item;
import org.bitbiome.shop.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopCommand implements CommandAPI{

            Shop shop = new Shop();
        public ShopCommand(){

        }

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println("Willkommen im Shop!");
        ArrayList<Item> currentItems = shop.loadCurrentShopItems();


        while (true){
            System.out.println("Was willst Du hier im Shop?");
            System.out.println("Etwas kaufen: 1");
            System.out.println("Das Quiz spielen: 2");
            System.out.println("Den Shop verlassen: 3");

            String input = scanner.nextLine();
            if(validInput(input)){
                if(input.equals("1")){
                    System.out.println("Folgende sind folgende Items im Shop: ");
                    for(int i = 0; i < currentItems.size(); i++){
                        System.out.println((i + 1) + ". " + currentItems.get(i).name + " | Anzahl: " + currentItems.get(i).amount + " | Gold: " + currentItems.get(i).gold);
                    }
                    System.out.println("0 Eingeben um den Shop zu verlassen.");
                    System.out.println("");
                    System.out.print("Welches Item moechtest du kaufen? ");
                    String itemNumber = scanner.nextLine();
                    if(!itemNumber.equals("0")){
                        System.out.print("Anzahl eingeben: ");
                        String amount = scanner.nextLine();
                        if((Integer.parseInt(amount) <= currentItems.get(Integer.parseInt(itemNumber) - 1).amount) && ((Integer.parseInt(amount) - 1) > -1)){
                            shop.buy(currentItems.get(Integer.parseInt(itemNumber) - 1).name, Integer.parseInt(amount));
                            currentItems = shop.loadCurrentShopItems();
                            System.out.println("");
                            System.out.println("Vielen Dank für Ihren Einkauf!");
                        }else{
                            System.out.println("Fehler");
                        }
                    }
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
