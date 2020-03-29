package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

class Card {
    private List<CardSide> sides;

    Card() {
        sides = new ArrayList<>();
    }

    void addSide(CardSide cardSide) {
        sides.add(cardSide);
    }

    List<CardSide> getSides() {
        return sides;
    }

    CardSide getSide(int number) {
        try {
            return sides.get(number);
        } catch (IndexOutOfBoundsException e) {
            Utils.logS("WRONG SIDE INDEX " + number);
            return null;
        }
    }
}
