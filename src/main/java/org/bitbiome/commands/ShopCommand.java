package org.bitbiome.commands;

import org.bitbiome.shop.Shop;

import java.util.Scanner;

public class ShopCommand implements CommandAPI{

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        new Shop();
    }


}
