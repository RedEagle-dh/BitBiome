package org.bitbiome.shop;

public class Item {
    public String name;
    public String damage;
    public boolean crafting;
    public int durability;

    public Item(String name, String damage, boolean crafting, int durability){
        this.name = name;
        this.damage = damage;
        this.crafting = crafting;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public boolean isCrafting() {
        return crafting;
    }

    public void setCrafting(boolean crafting) {
        this.crafting = crafting;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}