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
        mob.setDamage(0F);
        mob.setHp(561.45F);
    }


    @Test
    public void testFriendly() {
        assertEquals(mob.isFriendly(), true);
    }

    @Test
    public void testDamage() {
        assertEquals(mob.getDamage(), 0F);
    }
    
    @Test
    public void testHp() {
        assertEquals(mob.getHp(), 561.45F);
    }
}
