package com.example.gwent.logic;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cardsHand;
    private Suit suit;
    private Rank rank;
    private int cardValue;
    private int handValue;
    private int handLenght;

    Deck deck = new Deck();

    public Hand() {
        this.cardsHand = new ArrayList<Card>();
        this.suit = suit;
        this.rank = rank;
        this.cardValue  = cardValue;
        this.handValue  = handValue;
        this.handLenght = handLenght;
    }

    public ArrayList<Card> buildHand() {
        this.handValue = 0;
        Card newCard = deck.generateRandomCard();
        this.cardsHand.add(newCard);
        for (Card card: cardsHand) {
            this.suit = card.getSuit();
            this.rank = card.getRank();
            this.cardValue = card.getValue(rank);
            this.handValue = this.handValue + this.cardValue;
        }
        return cardsHand;
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

    public ArrayList<Card> getCardsHand() {
        return this.cardsHand;
    }


}