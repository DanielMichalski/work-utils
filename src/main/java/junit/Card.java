package junit;

public class Card implements Comparable<Card> {

    private static final int THE_SAME_VALUE = 0;

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int compareTo(Card o) {
        if (rank != o.rank) {
            return rank.compareTo(o.getRank());
        } else {
            if (rank == Rank.JOKER) {
                return THE_SAME_VALUE;
            } else {
                return suit.compareTo(o.suit);
            }
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
