package io.github.zminsc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Card {
    private final Rank rank;
    private final Suit suit;

    private BufferedImage cardIcon;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;

        try {
            cardIcon = ImageIO.read(Objects.requireNonNull(
                    this.getClass().getClassLoader().getResourceAsStream(toImageURL()))
            );

            int w = cardIcon.getWidth() * 5;
            int h = cardIcon.getHeight() * 5;

            Image tmp = cardIcon.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            cardIcon = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            Graphics2D gc = cardIcon.createGraphics();
            gc.drawImage(tmp, 0, 0, null);
            gc.dispose();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public ImageIcon toImageIcon() {
        return new ImageIcon(cardIcon);
    }

    public String toImageURL() {
        String rankStr, suitStr;

        switch (rank) {
            case TWO:
                rankStr = "two";
                break;
            case THREE:
                rankStr = "three";
                break;
            case FOUR:
                rankStr = "four";
                break;
            case FIVE:
                rankStr = "five";
                break;
            case SIX:
                rankStr = "six";
                break;
            case SEVEN:
                rankStr = "seven";
                break;
            case EIGHT:
                rankStr = "eight";
                break;
            case NINE:
                rankStr = "nine";
                break;
            case TEN:
                rankStr = "ten";
                break;
            case JACK:
                rankStr = "jack";
                break;
            case QUEEN:
                rankStr = "queen";
                break;
            case KING:
                rankStr = "king";
                break;
            case ACE:
                rankStr = "ace";
                break;
            default:
                rankStr = "";
        }

        switch (suit) {
            case DIAMONDS:
                suitStr = "diamonds";
                break;
            case CLUBS:
                suitStr = "clubs";
                break;
            case HEARTS:
                suitStr = "hearts";
                break;
            case SPADES:
                suitStr = "spades";
                break;
            default:
                suitStr = "";
        }

        return rankStr + "-" + suitStr + ".png";
    }

    @Override
    public String toString() {
        String rankStr, suitStr;

        switch (rank) {
            case TWO:
                rankStr = "Two";
                break;
            case THREE:
                rankStr = "Three";
                break;
            case FOUR:
                rankStr = "Four";
                break;
            case FIVE:
                rankStr = "Five";
                break;
            case SIX:
                rankStr = "Six";
                break;
            case SEVEN:
                rankStr = "Seven";
                break;
            case EIGHT:
                rankStr = "Eight";
                break;
            case NINE:
                rankStr = "Nine";
                break;
            case TEN:
                rankStr = "Ten";
                break;
            case JACK:
                rankStr = "Jack";
                break;
            case QUEEN:
                rankStr = "Queen";
                break;
            case KING:
                rankStr = "King";
                break;
            case ACE:
                rankStr = "Ace";
                break;
            default:
                rankStr = "";
        }

        switch (suit) {
            case DIAMONDS:
                suitStr = "Diamonds";
                break;
            case CLUBS:
                suitStr = "Clubs";
                break;
            case HEARTS:
                suitStr = "Hearts";
                break;
            case SPADES:
                suitStr = "Spades";
                break;
            default:
                suitStr = "";
        }

        return rankStr + " of " + suitStr;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() == this.getClass()) {
            Card otherCard = (Card) other;
            return otherCard.getRank() == this.getRank() && otherCard.getSuit() == this.getSuit();
        }

        return false;
    }
}
