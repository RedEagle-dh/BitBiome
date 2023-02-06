package org.bitbiome.classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackJackTest {

    private static BlackJack bj;
    @BeforeAll
    public static void setUpTest() {
        bj = new BlackJack("UnitTest");
    }
    @Test
    public void testGetEntity() {
        assertEquals(BlackJack.Entity.PLAYER, bj.getEntity(1));
    }

    @Test
    public void testGetEntityBot() {
        assertEquals(BlackJack.Entity.BOT, bj.getEntity(2));
    }

}
