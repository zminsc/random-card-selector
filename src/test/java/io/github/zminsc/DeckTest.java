package io.github.zminsc;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void testSelectCardTopRemovesCard() {
        Deck deck = new Deck();
        Card card = deck.selectCard(Deck.Location.TOP);

        assertFalse(deck.containsCard(card));
    }

    @Test
    public void testSelectCardBottomRemovesCard() {
        Deck deck = new Deck();
        Card card = deck.selectCard(Deck.Location.BOTTOM);

        assertFalse(deck.containsCard(card));
    }

    @Test
    public void testSelectCardRandomRemovesCard() {
        Deck deck = new Deck();
        Card card = deck.selectCard(Deck.Location.RANDOM);

        assertFalse(deck.containsCard(card));
    }

    @Test
    public void testPutCardTopPutsBackCard() {
        Deck deck = new Deck();
        Card card = deck.selectCard(Deck.Location.RANDOM);
        deck.putCard(Deck.Location.TOP, card);

        assertTrue(deck.containsCard(card));
        assertEquals(card, deck.selectCard(Deck.Location.TOP));
    }

    @Test
    public void testPutCardBottomPutsBackCard() {
        Deck deck = new Deck();
        Card card = deck.selectCard(Deck.Location.RANDOM);
        deck.putCard(Deck.Location.BOTTOM, card);

        assertTrue(deck.containsCard(card));
        assertEquals(card, deck.selectCard(Deck.Location.BOTTOM));
    }

    @Test
    public void testPutCardRandomPutsBackCard() {
        Deck deck = new Deck();
        Card card = deck.selectCard(Deck.Location.RANDOM);
        deck.putCard(Deck.Location.RANDOM, card);

        assertTrue(deck.containsCard(card));
    }

}
