package org.bitbiome.commands;

import org.bitbiome.classes.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectCommandTest {

    @Test
    public void testIncreaseAmountInPlayerConfig() {
        CollectCommand command = new CollectCommand();
        JsonParser jp = new JsonParser();
        JSONObject o = jp.getJSONObject("playerconfig.json");
        JSONArray inventory = o.getJSONArray("inventory");
        int k = 0;
        int initialAmount = inventory.getJSONObject(k).getInt("amount");
        command.increaseAmountInPlayerConfig(inventory, k, jp, o);
        int finalAmount = inventory.getJSONObject(k).getInt("amount");
        assertEquals(initialAmount + 1, finalAmount);
    }

}