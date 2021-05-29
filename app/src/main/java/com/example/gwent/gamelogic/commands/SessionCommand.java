package com.example.gwent.gamelogic.commands;


import com.example.gwent.gamelogic.game.GameSession;


/**
 * Created by ybra on 19.12.2014.
 *
 * Defines the command that will be executed on game session
 */
public interface SessionCommand {

    void setGameSession(GameSession gameSession);
    void execute();
}
