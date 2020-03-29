package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private Utils utl = new Utils();
    private List<Card> cards;

    public Deck() {
        utl.setLog(true);
        utl.log("Creating new Array List of Cards");
        cards = new ArrayList<>();
    }

    public Deck(ArrayList<Card> cards) {
        utl.log("Creating Array List of cards from another List");
        this.cards = cards;
    }

    public void addCard() {
        utl.log("Adding a card to a deck");
    }
}
