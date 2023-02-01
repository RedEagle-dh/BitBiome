package org.bitbiome.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitbiome.entities.Location;
import org.bitbiome.entities.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static Player player;
    private static Location location;

    @BeforeAll
    public static void setPlayer() {
        player = new Player();
        location = new Location();
        
        location.setName("NewUnitWorld");
        
        player.setName("UnitPlayer");
        player.setLocation(location);
        player.setHp(100F);
    }

    @Test
    public void testPlayerName() {
        assertEquals("UnitPlayer", player.getName());
    }


    @Test
    public void testPlayerHp() {
        assertEquals(100F, player.getHp());
    }

    @Test
    public void testLocationNameFromPlayer() {
        assertEquals("NewUnitWorld", player.getLocation().getName());
    }

}
