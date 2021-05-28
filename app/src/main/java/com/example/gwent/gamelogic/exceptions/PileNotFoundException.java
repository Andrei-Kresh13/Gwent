package com.example.gwent.gamelogic.exceptions;

/**
 * Created by Yan-Home on 12/21/2014.
 */
public class PileNotFoundException extends RuntimeException {
    public PileNotFoundException(final int pileIndex) {
        super("Pile with index : " + pileIndex + " is not found in the game session");
    }
}