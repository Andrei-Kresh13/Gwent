package com.example.gwent.logic_game.cards.commands.core;

import com.example.gwent.logic_game.cards.commands.cards.Card;
import com.example.gwent.logic_game.cards.commands.cards.Pile;
import com.example.gwent.logic_game.cards.commands.BaseSessionCommand;
import com.example.gwent.logic_game.cards.commands.exceptions.CardNotFoundException;
import com.example.gwent.logic_game.cards.commands.exceptions.PileNotFoundException;
import com.example.gwent.logic_game.cards.commands.validation.GameSessionValidations;

//Перемещение карты из стопки в стопку
public class MoveCardFromPileToPileCommand extends BaseSessionCommand {
    //must be the exact instance of the card that should be moved
    private Card mCardToMove;
    private int mFromPileIndex = -1;
    private int mToPileIndex = -1;

    public void setCardToMove(final Card mCardToMove) {
        this.mCardToMove = mCardToMove;
    }

    public void setFromPileIndex(final int mFromPileIndex) {
        this.mFromPileIndex = mFromPileIndex;
    }

    public void setToPileIndex(final int mToPileIndex) {
        this.mToPileIndex = mToPileIndex;
    }

    @Override
    public void execute() {
        validatePilesExist();


        final Pile fromPile = getGameSession().getPilesStack().get(mFromPileIndex);
        final Pile toPile = getGameSession().getPilesStack().get(mToPileIndex);

        for (int i = 0; i < fromPile.getCardsInPile().size(); i++) {
            final Card card = fromPile.getCardsInPile().get(i);
            if (mCardToMove.equals(card)) {
                fromPile.removeCardFromPile(card);
                toPile.addCardToPile(card);
                return;
            }
        }

        throw new CardNotFoundException(mCardToMove, mFromPileIndex);
    }

    private void validatePilesExist() {
        if (!GameSessionValidations.validatePilesExist(mFromPileIndex, getGameSession()))
            throw new PileNotFoundException(mFromPileIndex);

        if (!GameSessionValidations.validatePilesExist(mToPileIndex, getGameSession()))
            throw new PileNotFoundException(mToPileIndex);
    }


    public Card getCardToMove() {
        return mCardToMove;
    }

    public int getFromPileIndex() {
        return mFromPileIndex;
    }

    public int getToPileIndex() {
        return mToPileIndex;
    }
}
