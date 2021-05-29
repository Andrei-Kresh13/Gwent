package com.example.gwent.gamelogic.commands.core;


import com.example.gwent.gamelogic.commands.BaseSessionCommand;


/**
 * This command discards any state changes on the game , and resets the game
 * to its default initial state.
 */
public class ResetGameDataCommand extends BaseSessionCommand {
    @Override
    public void execute() {
        //clear all players
        getGameSession().getPlayers().clear();

        //clear all pending commands
        getGameSession().getPendingCommandsQueue().clear();

        //clear all executed commands
        getGameSession().getExecutedCommandsStack().clear();

        //clear all piles
        getGameSession().getPilesStack().clear();

        //set trump to null
        getGameSession().setTrumpSuit(null);
    }
}
