package org.bitbiome.entitiesTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitbiome.entities.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ItemTest {
    
    private static Item item;

    @BeforeAll
    public static void setItem() {
        item = new Item();
        item.setName("Unit");
    }

    @Test 
    public void testGetName() {
        assertEquals("Unit", item.getName());
    }
}
