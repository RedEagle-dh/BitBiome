package org.bitbiome.commands;

import org.bitbiome.shop.Shop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopCommandTest {
    final ShopCommand shopCommand = new ShopCommand();
    final Shop shop = new Shop();
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



    @Test
    public void testSubtractGold(){
        int expected = 1;
        int result = shop.subtractGold(3, 2);
        assertEquals(expected, result);
    }
    @Test
    public void testSubtractGold1(){
        int expected = 10;
        int result = shop.subtractGold(12, 2);
        assertEquals(expected, result);
    }
    @Test
    public void testSubtractGold2(){
        int expected = 4;
        int result = shop.subtractGold(7, 3);
        assertEquals(expected, result);
    }
    @Test
    public void testSubtractGold3(){
        int expected = 5;
        int result = shop.subtractGold(10, 5);
        assertEquals(expected, result);
    }
    @Test
    public void testSubtractGold4(){
        int expected = 1;
        int result = shop.subtractGold(2, 1);
        assertEquals(expected, result);
    }
    @Test
    public void testSubtractGold5(){
        int expected = 10;
        int result = shop.subtractGold(20, 10);
        assertEquals(expected, result);
    }

    @Test
    public void testSubtractGold6(){
        int expected = 12;
        int result = shop.subtractGold(24, 12);
        assertEquals(expected, result);
    }
}
