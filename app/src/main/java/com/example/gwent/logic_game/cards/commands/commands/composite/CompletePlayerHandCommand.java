package com.example.gwent.logic_game.cards.commands.commands.composite;


import com.example.gwent.logic_game.cards.commands.BaseSessionCommand;
import com.example.gwent.logic_game.cards.commands.cards.Pile;
import com.example.gwent.logic_game.cards.commands.cards.game.IGameRules;
import com.example.gwent.logic_game.cards.commands.commands.composite.CompletePileToAmountOfCards;
import com.yan.durak.gamelogic.cards.Pile;
import com.yan.durak.gamelogic.commands.BaseSessionCommand;
import com.yan.durak.gamelogic.game.IGameRules;

/**
 * Created by Yan-Home on 12/23/2014.
 */
// рука игрока
public class CompletePlayerHandCommand extends BaseSessionCommand {

    private int mPlayerIndex;

    @Override
    public void execute() {
        final int indexOfStockPile = getGameSession().getPilesStack().indexOf(getGameSession().findPileByTag(Pile.PileTags.STOCK_PILE_TAG));
        final CompletePileToAmountOfCards moveTopCardsFromPileToPilePlayerOne = new CompletePileToAmountOfCards();
        moveTopCardsFromPileToPilePlayerOne.setFromPileIndex(indexOfStockPile);
        moveTopCardsFromPileToPilePlayerOne.setToPileIndex(getGameSession().getPlayers().get(mPlayerIndex).getPileIndex());
        moveTopCardsFromPileToPilePlayerOne.setCardsAmount(IGameRules.AMOUNT_OF_CARDS_IN_PLAYER_HANDS);
        getGameSession().executeCommand(moveTopCardsFromPileToPilePlayerOne);
    }

    public void setPlayerIndex(final int playerIndex) {
        mPlayerIndex = playerIndex;
    }
}
