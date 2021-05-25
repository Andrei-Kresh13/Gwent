package com.example.gwent.cards;

// Класс определяет карту
public class Card {
    //колоды карт
    public static class Suit {
        public static final String UNDEAD = "undead";
        public static final String HUMAN = "human";
        public static final String WILDNESS = "wildness";
    }

    //сами карты
    public static class Rank {
        //написать карты сюда нужно
    }

    private String mRank;
    private String mSuit;

    public Card(final String rank, final String suit) {
        mRank = rank;
        mSuit = suit;
    }

    public String getRank() {
        return mRank;
    }

    public String getSuit() {
        return mSuit;
    }
    @Override
    public String toString() {
        return "Card{" +
                "mRank='" + mRank + '\'' +
                ", mSuit='" + mSuit + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        final Card card = (Card) o;

        if (!mRank.equals(card.mRank)) return false;
        if (!mSuit.equals(card.mSuit)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mRank.hashCode();
        result = 31 * result + mSuit.hashCode();
        return result;
    }
}



