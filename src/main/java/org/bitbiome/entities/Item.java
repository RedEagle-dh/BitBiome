package org.bitbiome.entities;

public class Item {

    private String name;
    private boolean doesDamage;
    private float damage;


    public Item(String name, boolean doesDamage, float damage) {
        this.name = name;
        this.doesDamage = doesDamage;
        this.damage = damage;
    }

    public Item() {
        
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }

    public boolean doesDamage() {
        return doesDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void changeDoesDamage(boolean doesDamage) {
        this.doesDamage = doesDamage;
    }

}
