package eu.theritual.phisher.rider;

import static eu.theritual.phisher.rider.InformationType.*;

public class PhishRiderDeck extends Deck{
    public static void main(String[] args) {
        System.out.println("This is just lib to use with other TheRitual 'Phisher' projects.");
        Deck deck = new Deck();

        deck.addInformation(TEXT, "Informacja 2");
        deck.addInformation(TEXT, "Informacja 3");
        deck.changeInformation(1,"Changed Information");
        deck.setCurrentInformation(2);
        deck.changeInformation("Another Changed Informaton");

        System.out.println(deck.current());

        deck.addCard();
        deck.addCard();
        deck.addCard();

        deck.setCurrentCard(1);

        deck.addCardSide(CardSideType.BASIC);
        deck.addCardSide(CardSideType.DOUBLE_TEXT);
        deck.addCardSide(CardSideType.BASIC);

        deck.setCurrentSide(1);

        deck.changeInformation("LOLZ MASTER");
        deck.addInformation(TEXT,"LOLZ SON");
        deck.addInformation(TEXT,"LOLZ GRANDSON");

        deck.changeCardSideType(1,1,CardSideType.DOUBLE_TEXT);

        deck.removeInformation(1,1,1);
        deck.removeSide(1,2);
        deck.removeCard(2);

        System.out.println("\n\n");

        deck.addCard(CardSideType.DOUBLE_TEXT, TEXT,"TEXT na nowej karcie");
        deck.addInformation("Drugi tekst bo to double");

        deck.show();

    }

}
