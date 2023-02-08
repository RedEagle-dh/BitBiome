package org.bitbiome.entities;

public class Mob {

    private String name;
    private boolean isFriendly;

    private float hp;
    private float damage;

    public Mob(String name, boolean isFriendly, float hp, float damage) {
        this.name = name;
        this.isFriendly = isFriendly;
        this.hp = hp;
        this.damage = damage;
    }

    public Mob() {
        
    }

    public String getName() {
        return name;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public float getHp() {
        return hp;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setFriendly(boolean isFriendly) {
        this.isFriendly = isFriendly;
    }


}
