package com.example.gwent.gamelogic.commands.custom;


import com.example.gwent.gamelogic.cards.Card;
import com.example.gwent.gamelogic.cards.Pile;
import com.example.gwent.gamelogic.commands.BaseSessionCommand;
import com.example.gwent.gamelogic.commands.composite.MoveCardsListFromPileToPile;


import java.util.Iterator;
import java.util.List;

//import static com.yan.durak.gamelogic.cards.Pile.PileTags.FIELD_PILE;

/**
 * Created by Yan-Home on 12/23/2014.
 * <p/>
 * moves all the cards from field piles to another pile
 * and removes references for field piles from game session.
 */
public class MoveAllFieldPilesCardsCommand extends BaseSessionCommand {
    private int toPileIndex;

    public void setToPileIndex(final int toPileIndex) {
        this.toPileIndex = toPileIndex;
    }

    @Override
    public void execute() {
        for (int i = 0; i < getGameSession().getPilesStack().size(); i++) {
            final Pile pile = getGameSession().getPilesStack().get(i);
            if (pile.hasTag(FIELD_PILE)) {
                issueMoveCardListCommand(pile.getCardsInPile(), toPileIndex, getGameSession().getPilesStack().indexOf(pile));
            }
        }

        //remove all field piles from game session
        final Iterator<Pile> iterator = getGameSession().getPilesStack().iterator();
        while (iterator.hasNext()) {
            final Pile pile = iterator.next();
            if (pile.hasTag(FIELD_PILE)) {
                iterator.remove();
            }
        }
    }

    private void issueMoveCardListCommand(final List<Card> cardListToBeMoved, final int toPileIndex, final int fromPileIndex) {
        final MoveCardsListFromPileToPile moveCardFromPileToPileCommand = new MoveCardsListFromPileToPile();
        moveCardFromPileToPileCommand.setCardList(cardListToBeMoved);
        moveCardFromPileToPileCommand.setToPileIndex(toPileIndex);
        moveCardFromPileToPileCommand.setFromPileIndex(fromPileIndex);
        getGameSession().executeCommand(moveCardFromPileToPileCommand);
    }

    public int getToPileIndex() {
        return toPileIndex;
    }
}
