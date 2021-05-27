package com.example.gwent.logic_game.cards.commands.exceptions;

/**
 * Created by Yan-Home on 12/21/2014.
 */
public class EmptyPileException extends RuntimeException {
    public EmptyPileException(final int pileIndex) {
        super("the pile " +  pileIndex + " is empty !");
    }
}