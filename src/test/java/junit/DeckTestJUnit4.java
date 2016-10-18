package junit;

import org.junit.Ignore;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DeckTestJUnit4 {

    @Test
    public void testShouldShuffleCards() throws Exception {
        // given
        Deck deck = new Deck(true);
        int cardsCount = deck.getCardsCount();

        // when
        Card[] shuffledCards = deck.shuffle();

        // then
        assertThat(shuffledCards, is(notNullValue()));
        assertThat(shuffledCards.length, is(cardsCount));
    }

    @Test
    public void testShouldSortCards() throws Exception {
        // given
        Deck deck = new Deck(true);

        // when
        Card[] sorted = deck.sort();

        // then
        assertThat(sorted, is(notNullValue()));
        assertThat(sorted[0].getRank(), is(Rank.TWO));
    }

    @Test
    public void testShouldGetFirstCard() throws Exception {
        // given
        Deck deck = new Deck(true);

        // when
        Card first = deck.getFirst();

        // then
        assertThat(first, is(notNullValue()));
        assertThat(first.getRank(), is(Rank.TWO));
    }

    @Test
    public void testShouldReturnTrueWhenJokerExistsInDeck() throws Exception {
        // given
        Deck deck = new Deck(true);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        assertThat(hasJoker, is(true));
    }

    @Test(timeout = 1000L)
    public void testShouldReturnFalseWhenJokerExistsInDeck() throws Exception {
        // given
        Deck deck = new Deck(false);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        assertThat(hasJoker, is(false));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void testThrowExceptionWhenShuffle() throws Exception {
        // given
        Deck deck = new Deck(false);

        // when
        Card[] shuffled = deck.shuffle();
    }

}