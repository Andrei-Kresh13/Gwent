package com.example.gwent.logic_game.cards.commands;

import com.example.gwent.cards.game.GameSession;

public class BaseSessionCommand implements SessionCommand{

    private GameSession mGameSession;
    @Override
    public void setGameSession(GameSession gameSession) {
        mGameSession = gameSession;
    }

    @Override
    public GameSession execute() {
        return mGameSession;
    }
}
