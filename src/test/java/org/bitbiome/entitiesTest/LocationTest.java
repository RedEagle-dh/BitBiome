package org.bitbiome.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitbiome.entities.Location;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LocationTest {
    
    private static Location location;


    @BeforeAll
    public static void setLocation() {
        location = new Location();
        location.setName("NewUnitWorld");
    }

    @Test
    public void testLocationName() {
        assertEquals("NewUnitWorld", location.getName());
    }
}
