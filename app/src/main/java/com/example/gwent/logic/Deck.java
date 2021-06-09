package com.example.gwent.logic;

import java.util.ArrayList;
import java.util.Random;


public class Deck {

    private ArrayList<Card> deck;
    private Random random = new Random();

    public Deck() {
        this.deck = new ArrayList<Card>();
        createDeck();
    }

    public Card generateRandomCard() {
        int num = random.nextInt(deck.size());
        Card card = deck.get(num);
        return card;
    }


    public void createDeck(){
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add( new Card(suit, rank));
            }
        }
    }




}