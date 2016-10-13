package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DeckTestJUnit4 {

    private static final Card FIRST_CARD = new Card(4);
    private static final Card SECOND_CARD = new Card(2);
    private static final Card THIRD_CARD = new Card(1);

    private Card[] cards;

    @Before
    public void setUp() throws Exception {
        cards = new Card[3];
        cards[0] = FIRST_CARD;
        cards[1] = SECOND_CARD;
        cards[2] = THIRD_CARD;
    }

    @After
    public void tearDown() throws Exception {
        cards = null;
    }

    @Test
    public void testShouldShuffleCards() throws Exception {
        // given
        Deck deck = new Deck(cards, true);

        // when
        Card[] shuffledCards = deck.shuffle();

        // then
        assertThat(shuffledCards, is(notNullValue()));
        assertThat(shuffledCards.length, is(cards.length));
    }

    @Test
    public void testShouldSortCards() throws Exception {
        // given
        Deck deck = new Deck(cards, true);

        // when
        Card[] sorted = deck.sort();

        // then
        assertThat(sorted, is(notNullValue()));
        assertThat(sorted[0], is(THIRD_CARD));
    }

    @Test
    public void testShouldGetFirstCard() throws Exception {
        // given
        Deck deck = new Deck(cards, true);

        // when
        Card first = deck.getFirst();

        // then
        assertThat(first, is(notNullValue()));
        assertThat(first, is(FIRST_CARD));
    }

    @Test
    public void testShouldReturnTrueWhenJokerExistsInDeck() throws Exception {
        // given
        Deck deck = new Deck(cards, true);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        assertThat(hasJoker, is(true));
    }

    @Test(timeout = 1000L)
    public void testShouldReturnFalseWhenJokerExistsInDeck() throws Exception {
        // given
        Deck deck = new Deck(cards, false);

        // when
        boolean hasJoker = deck.isHasJoker();

        // then
        assertThat(hasJoker, is(false));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void testThrowExceptionWhenShuffle() throws Exception {
        // given
        Deck deck = new Deck(cards, false);

        // when
        Card[] shuffled = deck.shuffle();
    }

}