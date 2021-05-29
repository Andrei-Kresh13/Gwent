package com.example.gwent.gamelogic.exceptions;


import com.example.gwent.gamelogic.cards.Card;


/**
 * Created by Yan-Home on 12/21/2014.
 */
public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(final Card card, final int pileIndex) {
        super("the card " + card + " is not found in pile index : " + pileIndex);
    }
}