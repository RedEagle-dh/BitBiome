package org.bitbiome.shop;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Shop {
    public ArrayList<Item> allItems;
    public ArrayList<Item> currentShopItems;

    public Shop() {
        try {
            allItems = loadAllItems();
            currentShopItems = loadPartofItems(allItems, 3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean buy(String itemName, int amount){
        //Create File Objects
        currentShopItems = loadCurrentShopItems();
        File filePlayerConfig = new File("src/main/resources/playerconfig.json");
        File fileGameConfig = new File("src/main/resources/gameconfig.json");
        File fileItem = new File("src/main/resources/items.json");
        try {
            //Create JSONObjects
            String content1 = new String(Files.readAllBytes(Paths.get(filePlayerConfig.toURI())), "UTF-8");
            JSONObject playerConfig = new JSONObject(content1);

            String content2 = new String(Files.readAllBytes(Paths.get(fileGameConfig.toURI())), "UTF-8");
            JSONObject gameConfig = new JSONObject(content2);

            String content3 = new String(Files.readAllBytes(Paths.get(fileItem.toURI())), "UTF-8");
            JSONArray itemJSON = new JSONArray(content3);

            //Test if item still available in the shop
            int itemIndex = -1;
            for(int i = 0; i < currentShopItems.size(); i++){
                if(currentShopItems.get(i).getName().equals(itemName)){
                    itemIndex = i;
                }
            }
            if(itemIndex == -1){
                System.out.println("Dieses Item gibt es nicht");
                return false;
            }
            if(!(currentShopItems.get(itemIndex).amount > 0)){
                System.out.println("Es gibt zu wenige Items");
                return false;
            }
            //Test if the player has enough gold
            int costs = currentShopItems.get(itemIndex).gold * amount;
            int gold = (int) playerConfig.get("gold");
            if(!(gold >= costs)){
                System.out.println("Du hast zu wenig Gold!");
                return false;
            }

            //Player gold subtract
            gold -= costs;
            playerConfig.put("gold", gold);

            //Gameconfig amount reduese
            JSONArray jsonArray2 = gameConfig.getJSONArray("shopitems");
            int intNewAmount;

            for(int i = 0; i < jsonArray2.length(); i++) {
                JSONObject tempJSON = jsonArray2.getJSONObject(i);
                if (tempJSON.getString("name").equals(itemName)) {
                    intNewAmount = tempJSON.getInt("amount") - amount;
                    jsonArray2.remove(i);
                    tempJSON.put("amount", intNewAmount);
                    jsonArray2.put(tempJSON);
                    gameConfig.put("shopitems", jsonArray2);
                    FileWriter fileWriter = new FileWriter("src/main/resources/gameconfig.json");
                    fileWriter.write(gameConfig.toString());
                    fileWriter.close();
                    currentShopItems = loadCurrentShopItems();
                    break;
                }
            }

            //Give Player the Item
            JSONArray jsonArray = playerConfig.getJSONArray("inventory");
            int newAmount;
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject tempJSON = jsonArray.getJSONObject(i);
                if (tempJSON.getString("name").equals(itemName)) {
                    newAmount = tempJSON.getInt("amount") + amount;
                    jsonArray.remove(i);
                    tempJSON.put("amount", newAmount);
                    jsonArray.put(tempJSON);
                    playerConfig.put("inventory", jsonArray);
                    FileWriter fileWriter = new FileWriter("src/main/resources/playerconfig.json");
                    fileWriter.write(playerConfig.toString());
                    fileWriter.close();
                    return true;
                }
            }

            //Item do not exist in the playerinventory
            int durability = 0;
            for(int i = 0; i < itemJSON.length(); i++) {
                JSONObject tempJSON = itemJSON.getJSONObject(i);
                if (tempJSON.getString("name").equals(itemName)) {
                    durability = (int) tempJSON.get("durability");
                }
            }

            JSONObject inventory = new JSONObject();
            inventory.put("name", itemName);
            inventory.put("amount", 1);
            inventory.put("durability", durability);

            jsonArray.put(inventory);
            playerConfig.put("inventory", jsonArray);
            FileWriter fileWriter = new FileWriter("src/main/resources/playerconfig.json");
            fileWriter.write(playerConfig.toString());
            fileWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    private ArrayList loadAllItems(){
        File file = new File("src/main/resources/items.json");
        ArrayList arrayList = new ArrayList<Item>();
        try {
            String content3 = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            JSONArray itemJSON = new JSONArray(content3);

            for(int i = 0; i < itemJSON.length(); i++){
                JSONObject tempJSON = itemJSON.getJSONObject(i);
                arrayList.add(new Item(tempJSON.getString("name"), tempJSON.getInt("amountShop"), tempJSON.getInt("gold")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return arrayList;
    }

    public ArrayList loadCurrentShopItems(){
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

    private ArrayList loadPartofItems(ArrayList<Item> alleItems, int itemCount) {
        ArrayList arrayList = new ArrayList<Item>();
        try{
        File fileGameConfig = new File("src/main/resources/gameconfig.json");
        String content2 = new String(Files.readAllBytes(Paths.get(fileGameConfig.toURI())), "UTF-8");
        JSONObject gameConfig = new JSONObject(content2);

        JSONArray jsonArray = gameConfig.getJSONArray("shopitems");
        HashSet<Integer> hashSet = new HashSet<>();
        JSONArray shopitems = new JSONArray();
        Random random = new Random();
        while (hashSet.size() < itemCount){
            int rand = random.nextInt(alleItems.size());
            if(!hashSet.contains(rand)){
                hashSet.add(rand);
                arrayList.add(alleItems.get(rand));
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", alleItems.get(rand).name);
                jsonObject.put("amount", alleItems.get(rand).amount);
                jsonObject.put("gold", alleItems.get(rand).gold);
                shopitems.put(jsonObject);
            }
        }
        //write in gameconfig.json
        gameConfig.remove("shopitems");
        gameConfig.put("shopitems", shopitems);
        FileWriter fileWriter = new FileWriter("src/main/resources/gameconfig.json");
        fileWriter.write(gameConfig.toString());
        fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return arrayList;
    }

    public void itemRotation() throws IOException {
        currentShopItems = loadPartofItems(allItems, 3);
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