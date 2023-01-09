package org.bitbiome.shop;

import java.util.ArrayList;

public class Shop {
    public ArrayList<Item> allItems;
    public ArrayList<Item> currentShopItems;

    public Shop(){
        allItems = loadItems();
    }

    public boolean buy(){
        //ToDo

        return true;
    }

    private ArrayList loadItems(){
        //ToDo

        return null;
    }

    public ArrayList<Item> itemRotation(ArrayList<Item> alleItems, int anzahlItemsImShop){
        //ToDo

        return null;
    }

    public ArrayList<Item> getCurrentShopItems(){
        return currentShopItems;
    }

    public void quiz(){
        //ToDo
    }

    private void printArrayList(ArrayList<Item> arrayList){
        System.out.println("");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).getName() + " | " + arrayList.get(i).getDamage() + " | " + arrayList.get(i).isCrafting() + " | " + arrayList.get(i).getDurability());
        }
        System.out.println("");
    }
}
