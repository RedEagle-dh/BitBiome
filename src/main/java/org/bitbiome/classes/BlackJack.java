package org.bitbiome.classes;

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
}
