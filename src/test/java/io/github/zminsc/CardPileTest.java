package io.github.zminsc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CardPileTest {

    @Test
    public void testPopWhenEmpty() {
        CardPile cardPile = new CardPile();

        assertEquals(0, cardPile.size());
        assertNull(cardPile.pop());
    }

    @Test
    public void testAddNull() {
        CardPile cardPile = new CardPile();
        cardPile.add(null);

        assertEquals(0, cardPile.size());
    }

    @Test
    public void testAddPopOneCard() {
        CardPile cardPile = new CardPile();
        Card card = new Card(Rank.THREE, Suit.DIAMONDS);

        cardPile.add(card);

        assertEquals(1, cardPile.size());
        assertEquals(card, cardPile.pop());
        assertEquals(0, cardPile.size());
    }

    @Test
    public void testAddPopTwoCards() {
        CardPile cardPile = new CardPile();
        Card cardOne = new Card(Rank.TWO, Suit.SPADES);
        Card cardTwo = new Card(Rank.JACK, Suit.CLUBS);

        cardPile.add(cardOne);
        cardPile.add(cardTwo);

        assertEquals(2, cardPile.size());
        assertEquals(cardTwo, cardPile.pop());
        assertEquals(1, cardPile.size());
        assertEquals(cardOne, cardPile.pop());
        assertEquals(0, cardPile.size());
    }

    @Test
    public void testClearEmpty() {
        CardPile cardPile = new CardPile();
        cardPile.clear();
    }

    @Test
    public void testClearOneCard() {
        CardPile cardPile = new CardPile();
        cardPile.add(new Card(Rank.SIX, Suit.HEARTS));

        assertEquals(1, cardPile.size());
        cardPile.clear();
        assertEquals(0, cardPile.size());
    }

    @Test
    public void testClearManyCards() {
        CardPile cardPile = new CardPile();
        Card[] cards = {new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.HEARTS), new Card(Rank.NINE, Suit.SPADES),
                new Card(Rank.TEN, Suit.DIAMONDS), new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.KING, Suit.SPADES),
                new Card(Rank.ACE, Suit.DIAMONDS)
        };

        for (Card card : cards) {
            cardPile.add(card);
        }

        assertEquals(13, cardPile.size());
        cardPile.clear();
        assertEquals(0, cardPile.size());
    }

}
