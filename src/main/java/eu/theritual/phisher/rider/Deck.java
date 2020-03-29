package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private boolean firstCard = true, firstSide = true, firstInformation = true;
    private int currentCard = 0, currentSide = 0, currentInformation = 0;
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        Utils.logS("Created new Deck as ArrayList of Cards");
        addBlankCard();
    }

    public void addBlankCard() {
        cards.add(new Card());
        if(!firstCard) {currentCard++; firstSide = true;} else { firstCard = false; }
        currentSide = 0;
        Utils.logS("Added Card with number " + currentCard + " to Deck");
        addBlankSide(CardSideType.BASIC);
    }

    public void addBlankSide(CardSideType type) {
        cards.get(currentCard).addSide(new CardSide(type));
        if(!firstSide) {currentSide++; firstInformation = true;} else { firstSide = false; }
        currentInformation = 0;
        Utils.logS("Added Blank Side of type (" + type + ") to Card " + currentCard);
        addInformation(InformationType.TEXT, "");
    }

    public void addInformation(InformationType type, String value) {
        cards.get(currentCard).getSide(currentSide).addInformation(type, value);
        if(!firstInformation) {currentInformation++;} else { firstInformation = false; }
        Utils.logS("Added Information of type (" + type + ") to side " + currentSide + " of card " + currentCard + " with value {" + value + "}");
    }

    List<Card> getCards() {
        return cards;
    }

    Card getCard(int number) {
        try {
            return cards.get(number);
        } catch (IndexOutOfBoundsException e) {
            Utils.logS("WRONG CARD INDEX " + number);
            return null;
        }
    }
}
