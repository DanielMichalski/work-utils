package junit;

public class Deck {

    private static final int DECK_SIZE = 52;
    private static final int JOKERS_COUNT = 2;

    private Card[] cards;
    private boolean hasJoker;

    public Deck(boolean hasJoker) {
        this.hasJoker = hasJoker;
        createDeck();
    }

    public Card[] shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = (int) (Math.random() * cards.length);
            Card temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }

    public Card[] sort() {
        int arrayLength = cards.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 1; j < arrayLength - i; j++) {
                if (cards[j - 1].getVal() > cards[j].getVal()) {
                    Card temp = cards[j - 1];
                    cards[j - 1] = cards[j];
                    cards[j] = temp;
                }
            }
        }
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
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.JOKER)) continue;
            for (Suit suit : Suit.values()) {
                if (suit.equals(Suit.NONE)) continue;
                cards[i] = new Card(suit, rank);
                i++;
            }
        }
        if (hasJoker) {
            cards[i] = new Card(Suit.NONE, Rank.JOKER);
            i++;
            cards[i] = new Card(Suit.NONE, Rank.JOKER);
        }
    }
}
