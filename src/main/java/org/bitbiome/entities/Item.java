package org.bitbiome.entities;

public class Item {

    private String name;
    private boolean doesDamage;
    private String damage;
    private int amount;
    private int gold;


    public Item(String name, boolean doesDamage, String damage, int amount, int gold) {
        this.name = name;
        this.doesDamage = doesDamage;
        this.damage = damage;
        this.amount = amount;
        this.gold = gold;
    }

    public Item() {
        
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDamage() {
        return damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold){
        this.gold = gold;
    }

    public boolean doesDamage() {
        return doesDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void changeDoesDamage(boolean doesDamage) {
        this.doesDamage = doesDamage;
    }

}
