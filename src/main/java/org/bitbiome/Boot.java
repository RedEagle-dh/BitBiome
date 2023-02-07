package org.bitbiome;

import org.bitbiome.classes.InteractionLoop;
import org.bitbiome.classes.JsonParser;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.commands.CommandListener;
import org.bitbiome.entities.Player;
import org.json.JSONObject;

public class Boot {

    private CommandListener cmdListener;
    public static Boot instance;
    public Boot() {
        instance = this;
        cmdListener = new CommandListener();
        InteractionLoop game = new InteractionLoop();
        Player player = getPlayerSave();
        TravelEngine travelEngine = new TravelEngine(player);
        game.run(travelEngine);
    }

    public CommandListener getCmdListener(){
        return cmdListener;
    }

    private Player getPlayerSave() {
        String name;
        JSONObject playerconfig = JsonParser.getJSONObject("src/main/resources/playerconfig.json");
        name = playerconfig.getString("name");
        return new Player(name);
    }

}



