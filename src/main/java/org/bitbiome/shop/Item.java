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

}