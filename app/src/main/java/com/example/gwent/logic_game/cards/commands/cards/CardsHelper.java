package com.example.gwent.logic_game.cards.commands.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CardsHelper {
    //Сколько всего карт в колоде
    public static final int MAX_CARDS_IN_DECK = 15;
    private static List<String> ORDERED_DECK_RANKS = Arrays.asList(new String[]{
            // прописать значения карт
    });
    public static Object compareCards(final Card leftCard, final Card rightCard, final String trumpSuite) {

        //suits are equal case
        if (leftCard.getSuit().equals(rightCard.getSuit())) {
            final int card1Index = ORDERED_DECK_RANKS.indexOf(leftCard.getRank());
            final int card2Index = ORDERED_DECK_RANKS.indexOf(rightCard.getRank());
            return card2Index - card1Index;
        }
        //suits are not equal , but left one is trump
        else if (leftCard.getSuit().equals(trumpSuite)) {
            return -1;
        }
        //suits are not equal , but right one is trump
        else if (rightCard.getSuit().equals(trumpSuite)) {
            return 1;
        }
        //none of cards is a trump , just compare by rank
        else {
            return 0;
        }

        public static ArrayList<Card> create15Deck() {
            final ArrayList<Card> deck = new ArrayList<>(36);
            deck.addAll(createSuit(Card.Suit.UNDEAD));
            deck.addAll(createSuit(Card.Suit.HUMAN));
            deck.addAll(createSuit(Card.Suit.WILDNESS));

            return deck;
        }
        private static Collection<? extends Card> createSuit(final String suit) {
            final ArrayList<Card> suitCards = new ArrayList<>(9);

            return suitCards;
        }

        public static List<Card> createNumberOfCards(final int cardsAmount) {
            final ArrayList<Card> deck = create15Deck();
            return deck.subList(0, cardsAmount);
        }

        public static List<Card> filterCardsBySuit(final Pile pile, final String suit) {
            final ArrayList<Card> filteredCards = new ArrayList<>(pile.getCardsInPile().size());
            for (int i = 0; i < pile.getCardsInPile().size(); i++) {
                final Card card = pile.getCardsInPile().get(i);
                if (card.getSuit().equals(suit)) {
                    filteredCards.add(card);
                }
            }
            return filteredCards;
        }

        public static boolean isOneOfTheRanksInPile(final Collection<String> ranks, final List<Card> cards) {
            for (int i = 0; i < cards.size(); i++) {
                final Card cardInPlayerPile = cards.get(i);
                for (final String allowedRank : ranks) {
                    if (cardInPlayerPile.getRank().equals(allowedRank)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
