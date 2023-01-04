package org.bitbiome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    @Test
    public void testLucky() {
        assertEquals(7, Main.getLucky());
    }

}
