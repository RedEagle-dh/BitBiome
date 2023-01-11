package org.bitbiome.shop;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Shop {
    public ArrayList<Item> allItems;
    public ArrayList<Item> currentShopItems;

    public Shop(){
        allItems = loadItems();
        currentShopItems = loadPartofItems(allItems, 2);
    }

    public boolean buy(){
        //ToDo

        return true;
    }

    private ArrayList loadItems(){
        File file = new File("src/main/resources/gameconfig.json");
        ArrayList arrayList = new ArrayList<Item>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            JSONObject jsonObject = new JSONObject(content);

            JSONArray jsonArray = jsonObject.getJSONArray("shopitems");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject tempJSON = jsonArray.getJSONObject(i);
                arrayList.add(new Item(tempJSON.getString("name"), tempJSON.getInt("amount"), tempJSON.getInt("gold")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return arrayList;
    }

    private ArrayList loadPartofItems(ArrayList<Item> alleItems, int itemCount){
        ArrayList arrayList = new ArrayList<Item>();
        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        while (hashSet.size() < itemCount){
            int rand = random.nextInt(alleItems.size());
            if(!hashSet.contains(rand)){
                hashSet.add(rand);
                arrayList.add(alleItems.get(rand));
            }
        }
        return arrayList;
    }

    public void itemRotation(){
        currentShopItems = loadPartofItems(allItems, 2);
    }

    public void printCurrentShopItems(){
        printArrayList(currentShopItems);
    }

    public void quiz(){
        //ToDo
    }

    private void printArrayList(ArrayList<Item> arrayList){
        System.out.println("");
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getAmount() != 0) {
                System.out.println(arrayList.get(i).getName() + " | Anzahl: " + arrayList.get(i).getAmount() + " | Kosten: " + arrayList.get(i).getGold());
            }
        }
        System.out.println("");
    }
}
