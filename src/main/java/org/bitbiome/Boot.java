package org.bitbiome;

import org.bitbiome.classes.InteractionLoop;
import org.bitbiome.commands.CommandListener;

public class Boot {

    private CommandListener cmdListener;
    public static Boot instance;
    public Boot() {
        instance = this;
        cmdListener = new CommandListener();
        InteractionLoop game = new InteractionLoop();
        game.run();
    }

    public CommandListener getCmdListener(){
        return cmdListener;
    }

}



