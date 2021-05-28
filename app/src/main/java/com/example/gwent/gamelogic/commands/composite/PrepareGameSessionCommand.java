package com.example.gwent.gamelogic.commands.composite;


import com.yan.durak.gamelogic.cards.Card;
import com.yan.durak.gamelogic.cards.CardsHelper;
import com.yan.durak.gamelogic.cards.Pile;
import com.yan.durak.gamelogic.commands.BaseSessionCommand;
import com.yan.durak.gamelogic.commands.core.ResetGameDataCommand;
import com.yan.durak.gamelogic.commands.core.SelectTrumpCommand;
import com.yan.durak.gamelogic.commands.core.ShufflePileAtPositionCommand;
import com.yan.durak.gamelogic.commands.custom.AddPileCommand;

import java.util.ArrayList;

/**
 * Created by Yan-Home on 12/22/2014.
 *
 * This command clears the game session
 * and allocates discard and stock piles.
 *
 * All will be ready for players to join and start the game.
 */
public class PrepareGameSessionCommand extends BaseSessionCommand {
    @Override
    public void execute() {
        //reset game state
        getGameSession().executeCommand(new ResetGameDataCommand());

        //init stock pile
        final AddPileCommand addStockPileCommand = new AddPileCommand();
        final Pile stockPile = new Pile();
        stockPile.addTag(Pile.PileTags.STOCK_PILE_TAG);
        addStockPileCommand.setPile(stockPile);
        addStockPileCommand.setCards(CardsHelper.create36Deck());

        //add a stock pile
        getGameSession().executeCommand(addStockPileCommand);

        //init discard pile
        final AddPileCommand addDiscardPileCommand = new AddPileCommand();
        final Pile pile = new Pile();
        pile.addTag(Pile.PileTags.DISCARD_PILE_TAG);
        addDiscardPileCommand.setPile(pile);
        addDiscardPileCommand.setCards(new ArrayList<Card>(CardsHelper.MAX_CARDS_IN_DECK));

        //add discard pile
        getGameSession().executeCommand(addDiscardPileCommand);

        final int indexOfStockPile = getGameSession().getPilesStack().indexOf(getGameSession().findPileByTag(Pile.PileTags.STOCK_PILE_TAG));

        //shuffle the stock pile
        final ShufflePileAtPositionCommand shufflePileCommand = new ShufflePileAtPositionCommand();
        shufflePileCommand.setPilePosition(indexOfStockPile);
        getGameSession().executeCommand(shufflePileCommand);

        //set trump
        final SelectTrumpCommand selectTrumpCommand = new SelectTrumpCommand();
        selectTrumpCommand.setTrumpPileIndex(indexOfStockPile);
        getGameSession().executeCommand(selectTrumpCommand);
    }
}
