package io.github.zminsc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testNewCardAceOfSpades() {
        Card c = new Card(Rank.ACE, Suit.SPADES);

        assertEquals(Rank.ACE, c.getRank());
        assertEquals(Suit.SPADES, c.getSuit());
        assertEquals("Ace of Spades", c.toString());
        assertEquals("ace-spades.png", c.toImageURL());
    }

    @Test
    public void testEqualsNull() {
        Card c = new Card(Rank.SEVEN, Suit.DIAMONDS);

        assertNotEquals(null, c);
    }

    @Test
    public void testEqualsAlias() {
        Card c = new Card(Rank.SEVEN, Suit.DIAMONDS);

        assertEquals(c, c);
    }

    @Test
    public void testEqualsTrue() {
        Card c1 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card c2 = new Card(Rank.SEVEN, Suit.DIAMONDS);

        assertEquals(c1, c2);
    }

    @Test
    public void testEqualsFalse() {
        Card c1 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card c2 = new Card(Rank.TEN, Suit.HEARTS);

        assertNotEquals(c2, c1);
    }

}
