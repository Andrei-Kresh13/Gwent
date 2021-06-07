package com.example.gwent.logic;

import java.util.ArrayList;

public class Hand {


    private ArrayList<Card> cardsInHand;
    private Suit suit;
    private Rank rank;
    private int cardValue;
    private int handValue;
    private int handSize;

    Deck deck = new Deck();

    public Hand() {
        this.cardsInHand = new ArrayList<Card>();
        this.suit = suit;
        this.rank = rank;
        this.cardValue  = cardValue;
        this.handValue  = handValue;
        this.handSize = handSize;
    }

    public ArrayList<Card> buildHand() {
        this.handValue = 0;
        Card newCard = deck.dealRandomCard();
        this.cardsInHand.add(newCard);
        for (Card card:cardsInHand) {
            this.suit = card.getSuit();
            this.rank = card.getRank();
            this.cardValue = card.getValue(rank);
            this.handValue = this.handValue + this.cardValue;
        }
        return cardsInHand;
    }

    public Suit getCardSuit() {
        return this.suit;
    }

    public Rank getCardRank() {
        return this.rank;
    }

    public int getCardValue() {
        return this.cardValue;
    }

    public ArrayList<Card> getCardsInHand() {
        return this.cardsInHand;
    }

}