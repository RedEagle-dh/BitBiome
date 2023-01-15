package org.bitbiome.commands;

import org.bitbiome.shop.Item;
import org.bitbiome.shop.Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopCommand implements CommandAPI{
    Shop shop = new Shop();

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        System.out.println("Willkommen im Shop!");
        System.out.println("Folgende Items sind aktuell im Shop:");
        shop.printCurrentShopItems();
        ArrayList<Item> currentItems;

        while (true){
            System.out.println("Was willst Du hier im Shop?");
            System.out.println("Etwas kaufen: 1");
            System.out.println("Das Quiz spielen: 2");
            System.out.println("Den Shop verlassen: 3");

            String input = scanner.nextLine();
            if(validInput(input)){
                if(input.equals("1")){
                    currentItems = shop.currentShopItems;
                    String inp = "";
                    System.out.println("");
                    System.out.println("Welches Item wollen Sie kaufen? ");
                    for(int i = 0; i < currentItems.size(); i++){
                        System.out.println((i + 1) + " eingaben fuer " + currentItems.get(i).name + " | Kosten: " + currentItems.get(i).gold + " | Anzahl: " + currentItems.get(i).amount);
                    }
                    System.out.println("0 eingeben fuer eine andere Option.");

                    while (true){
                        inp = scanner.nextLine();
                        if(inp.equals("0")){
                            break;
                        }
                        System.out.print("Anzahl eingeben: ");
                        int existingCount = currentItems.get(Integer.parseInt(inp) - 1).amount;
                        String inpAmount = scanner.nextLine();
                        if(Integer.parseInt(inpAmount) <= existingCount){
                            if(shop.buy(currentItems.get(Integer.parseInt(inp) - 1).name, Integer.parseInt(inpAmount))){
                                System.out.println("");
                                System.out.println("Vielen Dank fuer deinen Einkauf!");
                                System.out.println("");
                                break;
                            }else {
                                break;
                            }
                        }else {
                            System.out.println("Error!");
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
