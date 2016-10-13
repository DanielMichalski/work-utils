package junit;

public class Deck {

    private Card[] cards;
    private boolean hasJoker;

    public Deck(Card[] cards, boolean hasJoker) {
        this.cards = cards;
        this.hasJoker = hasJoker;
    }

    public Card[] shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = i + (int) (Math.random() * (cards.length - i));
            Card temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }

    public Card[] sort() {
        int arrayLength = cards.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 1; j < (arrayLength - i); j++) {
                if (cards[j-1].getVal() > cards[j].getVal()) {
                    Card temp = cards[j-1];
                    cards[j-1] = cards[j];
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
}
