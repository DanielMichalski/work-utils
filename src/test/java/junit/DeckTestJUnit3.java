package junit;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DeckTestJUnit3 extends TestCase {


    public void testShouldShuffleCards() throws Exception {
        // given
        Card[] cards = {
                new Card(4),
                new Card(2),
                new Card(1),
        };
        Deck deck = new Deck(cards, true);

        // when
        Card[] shuffledCards = deck.shuffle();

        // then
        Assert.assertFalse(shuffledCards == null);
        Assert.assertTrue(shuffledCards.length == cards.length);
    }

    public void testShouldSortCards() throws Exception {
        // given
        Card firstCard = new Card(2);
        Card secondCard = new Card(1);
        Card thirdCard = new Card(4);
        Card[] cards = {firstCard, secondCard, thirdCard};
        Deck deck = new Deck(cards, true);

        // when
        Card[] sorted = deck.sort();

        // then
        Assert.assertNotNull(sorted);
        Assert.assertTrue(sorted.length == cards.length);
        Assert.assertEquals(sorted[0], secondCard);
    }

    public void testShouldGetFirstCard() throws Exception {
        // given
        Card firstCard = new Card(2);
        Card secondCard = new Card(1);
        Card thirdCard = new Card(4);
        Card[] cards = {firstCard, secondCard, thirdCard};
        Deck deck = new Deck(cards, true);

        // when
        Card first = deck.getFirst();

        // then
        Assert.assertNotNull(first);
        Assert.assertSame(first, firstCard);
    }

    public void testShouldReturnTrueWhenJokerExistsInDeck() throws Exception {
        // given
        Card firstCard = new Card(2);
        Card secondCard = new Card(1);
        Card thirdCard = new Card(4);
        Card[] cards = {firstCard, secondCard, thirdCard};
        Deck deck = new Deck(cards, true);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        Assert.assertTrue(hasJoker);
    }

    public void testShouldReturnFalseWhenJokerExistsInDeck() throws Exception {
        // given
        Card firstCard = new Card(2);
        Card secondCard = new Card(1);
        Card thirdCard = new Card(4);
        Card[] cards = {firstCard, secondCard, thirdCard};
        Deck deck = new Deck(cards, false);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        Assert.assertFalse(hasJoker);
    }

}