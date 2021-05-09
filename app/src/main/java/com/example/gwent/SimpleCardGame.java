package com.example.gwent;

import java.util.Stack;

public class SimpleCardGame {
    //  колода
    private Stack<Card> deck;

    //  сброс
    private Stack<Card> graveyard;

    public Card getCardFromDeck() {
        return deck.pop();
    }

    public void discard(Card card) {
        graveyard.push(card);
    }

    public Card lookTopCard() {

        return deck.peek();
    }


    //  ..геттеры, сеттеры и т.д.
}
