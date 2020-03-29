package eu.theritual.phisher.rider;

import java.util.List;

public class Card {
    private CardType type;
    List<CardSide> sides;
    Card(CardType type, List<CardSide> sides) {
        this.type = type;
        this.sides = sides;
    }
}
