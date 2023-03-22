package io.github.zminsc;

import javax.swing.*;
import java.awt.*;

public class App implements Runnable {
    private final JFrame frame = new JFrame("Random Card Selector");

    private Deck currentDeck = new Deck();

    private Card currentCard;

    private final JLabel deckLabel = new JLabel(currentDeck.toImageIcon());

    private final JLabel cardLabel = new JLabel();

    private void changeCard(Card newCard) {
        currentCard = newCard;

        if (newCard == null) {
            cardLabel.setIcon(null);
        } else {
            cardLabel.setIcon(newCard.toImageIcon());
        }

        cardLabel.repaint();
        frame.pack();
    }

    private void putBackInDeck(Deck.Location location) {
        currentDeck.putCard(location, currentCard);
        changeCard(null);
    }

    private JPanel makeDeckControls() {
        final JPanel deckControls = new JPanel();
        deckControls.setLayout(new GridLayout(0, 1));

        final JButton shuffle = new JButton("Shuffle deck");
        final JButton selectTop = new JButton("Select top card");
        final JButton selectBottom = new JButton("Select bottom card");
        final JButton selectRandom = new JButton("Select random card");
        final JButton reset = new JButton("Reset deck");

        deckControls.add(new Label("Deck"));
        deckControls.add(shuffle);
        deckControls.add(selectTop);
        deckControls.add(selectBottom);
        deckControls.add(selectRandom);
        deckControls.add(reset);

        shuffle.addActionListener(e -> currentDeck.shuffle());

        selectTop.addActionListener(e -> changeCard(currentDeck.selectCard(Deck.Location.TOP)));

        selectBottom.addActionListener(e -> changeCard(currentDeck.selectCard(Deck.Location.BOTTOM)));

        selectRandom.addActionListener(e -> changeCard(currentDeck.selectCard(Deck.Location.RANDOM)));

        reset.addActionListener(e -> {
            changeCard(null);
            currentDeck = new Deck();
        });

        return deckControls;
    }

    private JPanel makeCardControls() {
        final JPanel cardControls = new JPanel();
        cardControls.setLayout(new GridLayout(0, 1));

        final JButton putTop = new JButton("Put in deck as top card");
        final JButton putBottom = new JButton("Put in deck as bottom card");
        final JButton putRandom = new JButton("Put in deck randomly");

        cardControls.add(new JLabel("Card"));
        cardControls.add(putTop);
        cardControls.add(putBottom);
        cardControls.add(putRandom);

        putTop.addActionListener(e -> putBackInDeck(Deck.Location.TOP));

        putBottom.addActionListener(e -> putBackInDeck(Deck.Location.BOTTOM));

        putRandom.addActionListener(e -> putBackInDeck(Deck.Location.RANDOM));

        return cardControls;
    }

    public void run() {
        frame.setLayout(new BorderLayout());

        final JPanel deckControls = makeDeckControls();
        final JPanel cardControls = makeCardControls();

        final JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(0, 1));

        controls.add(deckControls);
        controls.add(cardControls);

        final JPanel deckArea = new JPanel();
        deckArea.add(deckLabel);

        final JPanel cardArea = new JPanel();
        cardArea.add(cardLabel);

        final JPanel selectionArea = new JPanel();
        selectionArea.setLayout(new GridBagLayout());

        selectionArea.add(deckArea);
        selectionArea.add(cardArea);

        frame.add(controls, BorderLayout.LINE_START);
        frame.add(selectionArea, BorderLayout.CENTER);

        frame.pack();
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new App());
    }
}
