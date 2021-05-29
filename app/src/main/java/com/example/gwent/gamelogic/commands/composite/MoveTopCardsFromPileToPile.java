package com.example.gwent.gamelogic.commands.composite;


import com.example.gwent.gamelogic.cards.Card;
import com.example.gwent.gamelogic.commands.BaseSessionCommand;


import java.util.ArrayList;
import java.util.List;

//Изменить логику

/**
 * Created by ybra on 19.12.2014.
 */
public class MoveTopCardsFromPileToPile extends BaseSessionCommand {

    private int mFromPileIndex;
    private int mToPileIndex;
    private int mCardsAmount;

    public void setFromPileIndex(final int fromPileIndex) {
        mFromPileIndex = fromPileIndex;
    }

    public void setToPileIndex(final int toPileIndex) {
        mToPileIndex = toPileIndex;
    }

    public void setCardsAmount(final int cardsAmount) {
        mCardsAmount = cardsAmount;
    }

    @Override
    public void execute() {
        final ArrayList<Card> cardsToMove = new ArrayList<>(mCardsAmount);
        final List<Card> fromPile = getGameSession().getPilesStack().get(mFromPileIndex).getCardsInPile();

        //in case there is less cards in pile than we want to move
        final int amountOfCardsToMove = Math.min(fromPile.size(), mCardsAmount);
        for (int i = 0; i < amountOfCardsToMove; i++) {
            //obtain top card
            final Card card = fromPile.get(fromPile.size() - (i + 1));
            cardsToMove.add(card);
        }

        final MoveCardsListFromPileToPile moveCardsListFromPileToPile = new MoveCardsListFromPileToPile();
        moveCardsListFromPileToPile.setFromPileIndex(mFromPileIndex);
        moveCardsListFromPileToPile.setToPileIndex(mToPileIndex);
        moveCardsListFromPileToPile.setCardList(cardsToMove);
        getGameSession().executeCommand(moveCardsListFromPileToPile);
    }
}
