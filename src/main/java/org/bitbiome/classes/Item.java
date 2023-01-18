package org.bitbiome.classes;

public class Item {

    public String name;
    public boolean doesDamage;
    public float damage;


    public Item(String name, boolean doesDamage, float damage) {
        this.name = name;
        this.doesDamage = doesDamage;
        this.damage = damage;
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
