package io.github.zminsc;

import javax.swing.*;
import java.util.Stack;

public class CardPile {

    private final Stack<Card> cards = new Stack<>();

    public int size() {
        return cards.size();
    }

    public Card pop() {
        if (cards.empty()) {
            return null;
        }

        return cards.pop();
    }

    public void add(Card card) {
        if (card == null) {
            return;
        }

        cards.push(card);
    }

    public void clear() {
        while (!cards.empty()) {
            cards.pop();
        }
    }

    public ImageIcon toImageIcon() {
        if (cards.empty()) {
            return null;
        }

        return cards.peek().toImageIcon();
    }
}
