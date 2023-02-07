package org.bitbiome.entitiesTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.bitbiome.entities.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ItemTest {
    
    private static Item item;

    @BeforeAll
    public static void setItem() {
        item = new Item();
        item.setName("Unit");
        item.setDamage("12,5");
        item.changeDoesDamage(true);
        item.setAmount(5);
    }

    @Test 
    public void testGetName() {
        assertEquals("Unit", item.getName());
    }

    @Test 
    public void testGetDamage() {
        assertEquals("12,5", item.getDamage());
    }

    @Test 
    public void testDoesDamage() {
        boolean doesDamage = item.doesDamage();
        assumeTrue(item.getDamage().equals("12,5"));
        assumeTrue(doesDamage);
    }

    @Test
    public void testGetAmount() {
        assumeTrue(item.getAmount() == 5);
    }
}
