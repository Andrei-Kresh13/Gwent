package com.example.gwent.logic;


public class Card {

    private int value;
    private String cardDetails;
    private String cardImage;

    private Rule rule;
    private Suit suit;
    private Rank rank;



    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
        this.cardDetails = cardDetails;
        this.cardImage = cardImage;
    }

    public Rank getRank() {
        return this.rank;
    }


    public int getValue(Rank rank) {
        rule = new Rule(rank.toString());
        int value = rule.getValueFromRank(rank.toString());
        return value;
    }



    public Suit getSuit() {
        return this.suit;
    }



    public String getCardImage(String cardDetails) {

        // Wildness

        if (cardDetails.equals("ONE of WILDNESS")) {
            cardImage = "one_of_wildness";
        } else if (cardDetails.equals("TWO of WILDNESS")) {
            cardImage = "two_of_wildness";
        } else if (cardDetails.equals("THREE of WILDNESS")) {
            cardImage = "three_of_wildness";
        } else if (cardDetails.equals("FOUR of WILDNESS")) {
            cardImage = "four_of_wildness";
        } else if (cardDetails.equals("FIVE of WILDNESS")) {
            cardImage = "five_of_wildness";
        } else if (cardDetails.equals("SIX of WILDNESS")) {
            cardImage = "six_of_wildness";
        } else if (cardDetails.equals("SEVEN of WILDNESS")) {
            cardImage = "seven_of_wildness";
        }

        // Undead

        if (cardDetails.equals("ONE of UNDEAD")) {
            cardImage = "one_of_undead";
        } else if (cardDetails.equals("TWO of UNDEAD")) {
            cardImage = "two_of_undead";
        } else if (cardDetails.equals("THREE of UNDEAD")) {
            cardImage = "three_of_undead";
        } else if (cardDetails.equals("FOUR of UNDEAD")) {
            cardImage = "four_of_undead";
        } else if (cardDetails.equals("FIVE of UNDEAD")) {
            cardImage = "five_of_undead";
        } else if (cardDetails.equals("SIX of UNDEAD")) {
            cardImage = "six_of_undead";
        } else if (cardDetails.equals("SEVEN of UNDEAD")) {
            cardImage = "seven_of_undead";
        }

        // Human

        if (cardDetails.equals("ONE of HUMAN")) {
            cardImage = "one_of_human";
        } else if (cardDetails.equals("TWO of HUMAN")) {
            cardImage = "two_of_human";
        } else if (cardDetails.equals("THREE of HUMAN")) {
            cardImage = "three_of_human";
        } else if (cardDetails.equals("FOUR of HUMAN")) {
            cardImage = "four_of_human";
        } else if (cardDetails.equals("FIVE of HUMAN")) {
            cardImage = "five_of_human";
        } else if (cardDetails.equals("SIX of HUMAN")) {
            cardImage = "six_of_human";
        } else if (cardDetails.equals("SEVEN of HUMAN")) {
            cardImage = "seven_of_human";
        }

        return this.cardImage;
    }

}
