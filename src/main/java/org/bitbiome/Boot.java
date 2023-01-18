package org.bitbiome;

import org.bitbiome.classes.InteractionLoop;
import org.bitbiome.classes.TravelEngine;
import org.bitbiome.commands.CommandListener;
import org.bitbiome.entities.Player;

public class Boot {

    private CommandListener cmdListener;
    public static Boot instance;
    public Boot() {
        instance = this;
        cmdListener = new CommandListener();
        InteractionLoop game = new InteractionLoop();
        Player player = new Player("Dave");
        TravelEngine travelEngine = new TravelEngine(player);
        game.run(travelEngine);
    }

    public CommandListener getCmdListener(){
        return cmdListener;
    }

}



