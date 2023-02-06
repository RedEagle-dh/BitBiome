package org.bitbiome.classes;

import java.util.Random;

public class BlackJack {

    public enum Entity {
        PLAYER(1), BOT(2);
        private int value;

        private Entity(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        //Just for testing from some SO answers, but no use
        public void setValue(int value) {
            this.value = value;
        }

        public static Entity getEventStatusById(int id) {

            Entity entity = null;

            switch (id) {
                case 1 -> entity = PLAYER;
                case 2 -> entity = BOT;
                default -> {
                }
            }
            return entity;
        }
    }

    private String playerName;
    private int playerPoints;
    private int botPoints;
    private boolean playerIn;
    private boolean botIn;

    public BlackJack(String playerName) {
        this.playerName = playerName;
        this.playerPoints = 0;
        this.botPoints = 0;
        this.playerIn = true;
        this.botIn = true;
    }

    public String getPlayerName(Entity entity) {
        return entity == Entity.PLAYER ? playerName : "BitBiome";
    }

    public int getPoints(Entity entity) {
        return entity == Entity.PLAYER ? playerPoints : botPoints;
    }

    public boolean isIn(Entity entity) {
        return entity == Entity.PLAYER ? playerIn : botIn;
    }

    public Entity getEntity(int ID) {
        return Entity.getEventStatusById(ID);
    }

    public void addPoints(Entity entity, int points) {
        if (entity == Entity.BOT) botPoints += points;
        if (entity == Entity.PLAYER) playerPoints += points;
    }

    public boolean botWantsToPlay() {
        if (botIn) {
            if (botPoints <= 10) {
                return true;
            } else if (botPoints <= 17) {
                int r = new Random().nextInt(1, 9);
                if (r <= 3) {
                    botIn = false;
                    return false;
                } else {
                    return true;
                }
            } else {
                botIn = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public void playerOut() {
        this.playerIn = false;
    }
}
