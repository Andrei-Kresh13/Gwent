package com.example.gwent.gamelogic.commands.custom;


import com.example.gwent.gamelogic.cards.Pile;
import com.example.gwent.gamelogic.commands.BaseSessionCommand;
import com.example.gwent.gamelogic.game.IGameRules;

import java.util.ArrayList;
import java.util.List;

//import static com.yan.durak.gamelogic.cards.Pile.PileTags.FIELD_PILE;

/**
 * Created by Yan-Home on 12/25/2014.
 * <p/>
 * Command will analise filed piles condition and decide whether all field piles
 * are covered or not.
 */
public class CheckFieldPilesStatusCommand extends BaseSessionCommand {


    private boolean mEveryFieldPileCovered;
    private List<Pile> mUncoveredPiles;
    private List<Pile> mCoveredPiles;

    @Override
    public void execute() {

        //allocating new list
        mUncoveredPiles = new ArrayList<>(IGameRules.MAX_PILES_ON_FIELD_AMOUNT);
        mCoveredPiles = new ArrayList<>(IGameRules.MAX_PILES_ON_FIELD_AMOUNT);

        //depending on field piles status , decide what to do next
        mEveryFieldPileCovered = true;

        //filter all field piles
        for (int i = 0; i < getGameSession().getPilesStack().size(); i++) {
            final Pile pile = getGameSession().getPilesStack().get(i);
            if (pile.hasTag(FIELD_PILE)) {

                //check if the pile is uncovered (has 1 cards)
                if (pile.getCardsInPile().size() == 1) {
                    mEveryFieldPileCovered = false;
                    mUncoveredPiles.add(pile);
                }
                //check if card is covered (has 2 card)
                else if (pile.getCardsInPile().size() == 2) {
                    mCoveredPiles.add(pile);
                }
            }
        }
    }


    public boolean isEveryFieldPileCovered() {
        return mEveryFieldPileCovered;
    }

    public List<Pile> getUncoveredPiles() {
        return mUncoveredPiles;
    }

    public List<Pile> getCoveredPiles() {
        return mCoveredPiles;
    }
}
