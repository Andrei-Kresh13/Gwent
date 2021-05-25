package com.example.gwent.cards.game;

public interface IGameRules {
    int PLAYERS_IN_GAME = 2;
    /**
     * Defines the minimum amount of cards that player should have at the
     * beginning of each turn as long as stock pile is not empty
     */
    int AMOUNT_OF_CARDS_IN_PLAYER_HANDS = 5;
    /**
     * Defines the maximum amount of cards that player can
     * retaliate against.
     */
    int MAX_PILES_ON_FIELD_AMOUNT = 5;//додумать
}
