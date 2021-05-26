package com.example.gwent.logic_game.cards.commands.exceptions;

import com.example.gwent.logic_game.cards.commands.cards.Card;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(final Card card, final int pileIndex) {
        super("the card " + card + " is not found in pile index : " + pileIndex);
    }
}
