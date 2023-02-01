package org.bitbiome.entitiesTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.bitbiome.entities.Mob;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MobTest {
    
    private static Mob mob;

    @BeforeAll
    public static void setMob() {
        mob = new Mob();
        mob.setFriendly(true);   
    }


    @Test
    public void testFriendly() {
        assertEquals(mob.isFriendly(), true);
    }
    
}
