package com.example.gwent.logic_game.cards.commands;

import com.example.gwent.logic_game.cards.commands.cards.game.GameSession;

public abstract class BaseSessionCommand implements SessionCommand{

    private GameSession mGameSession;

    @Override
    public void setGameSession(final GameSession gameSession)
    {
        mGameSession = gameSession;
    }

    public GameSession getGameSession() {
        return mGameSession;
    }
}
