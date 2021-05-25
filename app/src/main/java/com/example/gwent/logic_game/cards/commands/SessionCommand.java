package com.example.gwent.logic_game.cards.commands;

import com.example.gwent.cards.game.GameSession;
//Defines the command that will be executed on game session
public interface SessionCommand {
    void setGameSession(GameSession gameSession);
    GameSession execute();
}
