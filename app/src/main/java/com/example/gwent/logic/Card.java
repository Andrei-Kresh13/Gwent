package com.example.gwent.logic;


public class Card {

    private int value;
    private String cardDetails;
    private String cardIcon;

    private Rule rule;
    private Suit suit;
    private Rank rank;



    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
        this.cardDetails = cardDetails;
        this.cardIcon = cardIcon;
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



    public String getCardIcon(String cardDetails) {

        // Wildness

        if (cardDetails.equals("ONE of WILDNESS")) {
            cardIcon = "ace_of_wildness";
        } else if (cardDetails.equals("TWO of WILDNESS")) {
            cardIcon = "two_of_wildness";
        } else if (cardDetails.equals("THREE of WILDNESS")) {
            cardIcon = "three_of_wildness";
        } else if (cardDetails.equals("FOUR of WILDNESS")) {
            cardIcon = "four_of_wildness";
        } else if (cardDetails.equals("FIVE of WILDNESS")) {
            cardIcon = "five_of_wildness";
        } else if (cardDetails.equals("SIX of WILDNESS")) {
            cardIcon = "six_of_wildness";
        } else if (cardDetails.equals("SEVEN of WILDNESS")) {
            cardIcon = "seven_of_wildness";
        }

        // Undead

        if (cardDetails.equals("ONE of UNDEAD")) {
            cardIcon = "one_of_undead";
        } else if (cardDetails.equals("TWO of UNDEAD")) {
            cardIcon = "two_of_undead";
        } else if (cardDetails.equals("THREE of UNDEAD")) {
            cardIcon = "three_of_undead";
        } else if (cardDetails.equals("FOUR of UNDEAD")) {
            cardIcon = "four_of_undead";
        } else if (cardDetails.equals("FIVE of UNDEAD")) {
            cardIcon = "five_of_undead";
        } else if (cardDetails.equals("SIX of UNDEAD")) {
            cardIcon = "six_of_undead";
        } else if (cardDetails.equals("SEVEN of UNDEAD")) {
            cardIcon = "seven_of_undead";
        }

        // Human

        if (cardDetails.equals("ONE of HUMAN")) {
            cardIcon = "one_of_human";
        } else if (cardDetails.equals("TWO of HUMAN")) {
            cardIcon = "two_of_human";
        } else if (cardDetails.equals("THREE of HUMAN")) {
            cardIcon = "three_of_human";
        } else if (cardDetails.equals("FOUR of HUMAN")) {
            cardIcon = "four_of_human";
        } else if (cardDetails.equals("FIVE of HUMAN")) {
            cardIcon = "five_of_human";
        } else if (cardDetails.equals("SIX of HUMAN")) {
            cardIcon = "six_of_human";
        } else if (cardDetails.equals("SEVEN of HUMAN")) {
            cardIcon = "seven_of_human";
        }

        return this.cardIcon;
    }

}
