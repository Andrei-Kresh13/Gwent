package com.example.gwent.logic_game.cards.commands.core;

import com.example.gwent.logic_game.cards.commands.BaseSessionCommand;

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
