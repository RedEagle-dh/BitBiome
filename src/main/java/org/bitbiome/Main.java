package org.bitbiome;

import org.json.JSONObject;

import java.util.Scanner;

public class Main {

    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        JSONObject playerConfig = JsonParser.getJSONObject("playerconfig.json");
    }
    public static int getLucky() {
        return 7;
    }

}