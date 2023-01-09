package org.bitbiome.shop;

import java.util.ArrayList;

public class Shop {
    public ArrayList<Item> allItems;
    public ArrayList<Item> currentShopItems;

    public Shop(){
        //allItems = loadItems();
        allItems = new ArrayList<Item>();
        allItems.add(new Item("Holz", 10, 10));
        allItems.add(new Item("Holz2", 11, 10));
        allItems.add(new Item("Holz3", 12, 10));
        allItems.add(new Item("Holz4", 13, 10));
        //currentShopItems = itemRotation(allItems, 3);
    }

    public boolean buy(){
        //ToDo

        return true;
    }

    private ArrayList loadItems(){
        //ToDo

        return null;
    }

    public ArrayList<Item> itemRotation(ArrayList<Item> alleItems, int itemCount){
        //ToDo

        return null;
    }

    public void getCurrentShopItems(){
        printArrayList(allItems);
    }

    public void quiz(){
        //ToDo
    }

    private void printArrayList(ArrayList<Item> arrayList){
        System.out.println("");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).getName() + " | Anzahl: " + arrayList.get(i).getAmount() + " | Kosten: " + arrayList.get(i).getGold());
        }
        System.out.println("");
    }
}
