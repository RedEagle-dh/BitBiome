package org.bitbiome.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ColorsTest {
    
    @Test
    public void testResetCode() {
        assertEquals("\u001B[0m", Colors.ANSI_RESET);
    }
}
