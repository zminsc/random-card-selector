package io.github.zminsc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Deck {
    private final ArrayList<Card> cards;
    private BufferedImage deckIcon;

    public enum Location {TOP, BOTTOM, RANDOM}

    public Deck() {
        cards = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }

        try {
            deckIcon = ImageIO.read(Objects.requireNonNull(
                    this.getClass().getClassLoader().getResourceAsStream("back-blue.png"))
            );

            int w = deckIcon.getWidth() * 5;
            int h = deckIcon.getHeight() * 5;

            Image tmp = deckIcon.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            deckIcon = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            Graphics2D gc = deckIcon.createGraphics();
            gc.drawImage(tmp, 0, 0, null);
            gc.dispose();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageIcon toImageIcon() {
        return new ImageIcon(deckIcon);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card selectCard(Location location) {
        if (cards.size() == 0) {
            return null;
        }

        Card selectedCard;

        switch (location) {
            case TOP:
                selectedCard = cards.get(0);
                break;
            case BOTTOM:
                selectedCard = cards.get(cards.size() - 1);
                break;
            case RANDOM:
                int index = (int) (Math.random() * cards.size());
                selectedCard = cards.get(index);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized location in deck.");
        }

        cards.remove(selectedCard);
        return selectedCard;
    }

    public void putCard(Location location, Card card) {
        if (card == null) {
            return;
        }

        switch (location) {
            case TOP:
                cards.add(0, card);
                break;
            case BOTTOM:
                cards.add(card);
                break;
            case RANDOM:
                int index = (int) (Math.random() * cards.size() + 1);
                cards.add(index, card);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized location in deck.");
        }
    }

    public boolean containsCard(Card card) {
        return cards.contains(card);
    }

}
