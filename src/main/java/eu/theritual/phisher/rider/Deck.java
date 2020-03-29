package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private Utils utl = new Utils(true);
    private List<Card> cards;

    public Deck() {
        utl.log("Creating new Array List of Cards");
        cards = new ArrayList<>();
    }

    public void addCard(CardType type, String vlues) {
        utl.log("Adding a card to a deck");

    }
}
