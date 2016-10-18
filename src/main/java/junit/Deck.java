package junit;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private static final int DECK_SIZE = 52;
    private static final int JOKERS_COUNT = 3;

    private Card[] cards;
    private boolean hasJoker;

    public Deck(boolean hasJoker) {
        this.hasJoker = hasJoker;
        createDeck();
    }

    public Card[] shuffle() {
        Collections.shuffle(Arrays.asList(cards));
        return cards;
    }

    public Card[] sort() {
        Arrays.sort(cards);
        return cards;
    }

    public Card getFirst() {
        return cards[0];
    }

    public boolean isHasJoker() {
        return hasJoker;
    }

    public int getCardsCount() {
        return cards.length;
    }

    private void createDeck() {
        int deckSize = hasJoker ? DECK_SIZE + JOKERS_COUNT : DECK_SIZE;
        cards = new Card[deckSize];
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                if (rank.equals(Rank.JOKER)) continue;
                cards[i] = new Card(suit, rank);
                i++;
            }
        }
        if (hasJoker) {
            for (int j = 0; j < JOKERS_COUNT; j++) {
                cards[i] = new Card(null, Rank.JOKER);
                i++;
            }
        }
    }
}
