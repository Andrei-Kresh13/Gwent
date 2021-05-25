package com.example.gwent.logic_game.cards.commands.exceptions;

public class PileNotFoundException extends RuntimeException{
    public PileNotFoundException(final int pileIndex) {
        super("Pile with index : " + pileIndex + " is not found in the game session");
    }
}
