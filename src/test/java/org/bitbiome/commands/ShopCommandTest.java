package org.bitbiome.commands;

import org.bitbiome.shop.Shop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopCommandTest {
    final ShopCommand shopCommand = new ShopCommand();
    @Test
    public void testValidInput1(){
        boolean expected = true;
        boolean result = shopCommand.validInput("1");
        assertEquals(expected, result);
    }
    @Test
    public void testValidInput2(){
        boolean expected = true;
        boolean result = shopCommand.validInput("2");
        assertEquals(expected, result);
    }
    @Test
    public void testValidInput3(){
        boolean expected = true;
        boolean result = shopCommand.validInput("3");
        assertEquals(expected, result);
    }
    @Test
    public void testValidInput4(){
        boolean expected = false;
        boolean result = shopCommand.validInput("4");
        assertEquals(expected, result);
    }
}
