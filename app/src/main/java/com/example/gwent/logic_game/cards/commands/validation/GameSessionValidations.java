package com.example.gwent.logic_game.cards.commands.validation;

import com.example.gwent.logic_game.cards.commands.cards.game.GameSession;
import com.example.gwent.logic_game.cards.commands.cards.game.IGameRules;

public class GameSessionValidations {

    /**
     * Validates that given pile index exists in provided game session
     *
     * @param pileIndex   index of pile to validate
     * @param gameSession game session to validate pile index in
     * @return true if pile exists , false otherwise
     */
    public static boolean validatePilesExist(final int pileIndex, final GameSession gameSession) {
        return (pileIndex < 0 || pileIndex >= gameSession.getPilesStack().size()) ? false : true;
    }

}
