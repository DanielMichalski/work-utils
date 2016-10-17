package junit;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DeckTestJUnit3 extends TestCase {


    public void testShouldShuffleCards() throws Exception {
        // given
        Deck deck = new Deck(true);
        int cardsCount = deck.getCardsCount();

        // when
        Card[] shuffledCards = deck.shuffle();

        // then
        Assert.assertFalse(shuffledCards == null);
        Assert.assertTrue(shuffledCards.length == cardsCount);
    }

    public void testShouldSortCards() throws Exception {
        // given
        Deck deck = new Deck(true);
        int cardsCount = deck.getCardsCount();

        // when
        Card[] sorted = deck.sort();

        // then
        Assert.assertNotNull(sorted);
        Assert.assertTrue(sorted.length == cardsCount);
        Assert.assertEquals(sorted[0].getVal(), 2);
    }

    public void testShouldGetFirstCard() throws Exception {
        // given
        Deck deck = new Deck(true);

        // when
        Card first = deck.getFirst();

        // then
        Assert.assertNotNull(first);
        Assert.assertSame(first.getVal(), 2);
    }

    public void testShouldReturnTrueWhenJokerExistsInDeck() throws Exception {
        // given
        Deck deck = new Deck(true);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        Assert.assertTrue(hasJoker);
    }

    public void testShouldReturnFalseWhenJokerExistsInDeck() throws Exception {
        // given
        Deck deck = new Deck(false);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        Assert.assertFalse(hasJoker);
    }

}