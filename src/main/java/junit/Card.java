package junit;

public class Card {
    private int val;

    public Card(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "Card{" +
                "val=" + val +
                '}';
    }
}
