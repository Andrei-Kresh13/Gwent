package com.example.gwent.gamelogic.commands.core;


import com.example.gwent.gamelogic.cards.Pile;
import com.example.gwent.gamelogic.commands.BaseSessionCommand;


import java.util.Collections;

/**
 * Created by ybra on 19.12.2014.
 */
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
