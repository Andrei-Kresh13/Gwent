package com.example.gwent.gamelogic.player;


import com.example.gwent.gamelogic.cards.Card;
import com.example.gwent.gamelogic.cards.Pile;
import com.example.gwent.gamelogic.game.GameSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yan-Home on 12/30/2014.
 */
public abstract class BasePlayer implements IPlayer {

    protected final GameSession mGameSession;
    protected int mIndexInGame;
    protected int mPileIndex;


    public BasePlayer(final int indexInGame, final GameSession gameSession,
                      final int pileIndex) {
        mIndexInGame = indexInGame;
        mGameSession = gameSession;
        mPileIndex = pileIndex;
    }

    @Override
    public int getGameIndex() {
        return mIndexInGame;
    }

    @Override
    public int getPileIndex() {
        return mPileIndex;
    }

    /**
     * Brings together cards from player hand that can be throwed in.
     *
     * @param allowedRanksToThrowIn all ranks that can be throwed in.
     * @return array of cards.
     */
    public List<Card> getPossibleThrowInCards(final Collection<String> allowedRanksToThrowIn) {

        final List<Card> retList = new ArrayList<>();
        final Pile playerPile = mGameSession.getPilesStack().get(getPileIndex());

        //just simply add every possible rank
        for (int i = 0; i < playerPile.getCardsInPile().size(); i++) {
            final Card cardInHand = playerPile.getCardsInPile().get(i);
            if (allowedRanksToThrowIn.contains(cardInHand.getRank())) {
                retList.add(cardInHand);
            }
        }

        return retList;
    }


}
