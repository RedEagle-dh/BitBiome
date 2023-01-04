package org.bitbiome;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class JsonParser {
    public static JSONObject getJSONObject(String fileName) {
        String resourceName = "./../../" + fileName;
        InputStream is = JsonParser.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        System.out.println("Name: " + object.getString("name"));

        System.out.println("Inventory: ");
        JSONArray inventory = object.getJSONArray("inventory");

        for (int i = 0; i < inventory.length(); i++) {
            JSONObject invObj = inventory.getJSONObject(i);
            System.out.println("  - " + invObj.getString("name"));
        }
        return object;
    }
}
