package com.example.gwent.gamelogic.commands.custom;


import com.yan.durak.gamelogic.cards.Card;
import com.yan.durak.gamelogic.cards.Pile;
import com.yan.durak.gamelogic.commands.BaseSessionCommand;
import com.yan.durak.gamelogic.utils.LogUtils;

import static com.yan.durak.gamelogic.utils.LogUtils.log;

/**
 * Created by ybra on 19.12.2014.
 * <p/>
 * This is a test command .
 */
public class LogPilesStatusCommand extends BaseSessionCommand {

    @Override
    public void execute() {

        if (!LogUtils.LOGGING_ENABLED)
            return;

        LogUtils.log("===================================================================================================================================\n");
        LogUtils.log("Selected trump suit is : " + getGameSession().getTrumpSuit());
        for (int i = 0; i < getGameSession().getPilesStack().size(); i++) {
            final Pile pile = getGameSession().getPilesStack().get(i);

            log("************************************************************************\n");
            log("Pile " + i + " : " + pile + " cards count = " + pile.getCardsInPile().size());
            log("--------------------------------------");
            for (int j = 0; j < pile.getCardsInPile().size(); j++) {
                final Card card = pile.getCardsInPile().get(j);
                log("Rank : " + card.getRank() + " Suit : " + card.getSuit());
            }
        }
    }
}