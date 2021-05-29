package com.example.gwent.gamelogic;


import com.example.gwent.gamelogic.commands.custom.startgame.GameStartCommand;
import com.example.gwent.gamelogic.communication.connection.ConnectedPlayer;
import com.example.gwent.gamelogic.game.GameSession;
import com.example.gwent.gamelogic.game.IGameRules;


/**
 * Created by ybra on 19.12.2014.
 * <p/>
 * Temporary class that binds logic together
 * Later planned to be removed and replaced by more sophisticated system,
 */
public class GameStarter {
    private final GameSession mGameSession;

    /**
     * Accepts array of players which are can be remote clients.
     * If instead of remote client null is provided , than player replaced with a BOT.
     */
    public GameStarter(final IGameRules gameRules, final ConnectedPlayer... connectedPlayers) {
        mGameSession = new GameSession();
        mGameSession.setGameRules(gameRules);
        final GameStartCommand gameStartCommand = new GameStartCommand();
        gameStartCommand.setConnectedPlayers(connectedPlayers);
        mGameSession.addCommand(gameStartCommand);
    }

    public void start() {
        mGameSession.startSession();
    }
}