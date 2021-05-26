package com.example.gwent.logic_game.cards.commands.core;

import com.example.gwent.logic_game.cards.commands.cards.Pile;
import com.example.gwent.logic_game.cards.commands.BaseSessionCommand;

import java.util.Collections;
//Перемешать стопку
public class ShufflePileAtPositionCommand extends BaseSessionCommand {
    private int mPilePosition;


    public void setPilePosition(final int pilePosition) {
        mPilePosition = pilePosition;
    }

    @Override
    public void execute() {
        final Pile pile = getGameSession().getPilesStack().get(mPilePosition);
        if (pile == null) {
            throw new RuntimeException("pile at index " + mPilePosition + " is not found");
        }
        Collections.shuffle(pile.getCardsInPile());
    }
}
