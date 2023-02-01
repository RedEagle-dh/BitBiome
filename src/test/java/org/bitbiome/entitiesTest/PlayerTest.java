package org.bitbiome.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitbiome.entities.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static Player player;

    @BeforeAll
    public static void setPlayer() {
        player = new Player();
        
        player.setName("UnitPlayer");
        
    }

    @Test
    public void testPlayerName() {
        assertEquals("UnitPlayer", player.getName());
    }

}
