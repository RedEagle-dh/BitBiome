package org.bitbiome.shop;

public class Item {
    public String name;
    public int amount;
    public int gold;


    public Item(String name, int amount, int gold){
        this.name = name;
        this.amount = amount;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}