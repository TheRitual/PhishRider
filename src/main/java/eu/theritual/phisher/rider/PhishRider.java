package eu.theritual.phisher.rider;

import static eu.theritual.phisher.rider.InformationType.*;

public class PhishRider {
    public static void main(String[] args) {
        System.out.println("This is just lib to use with other TheRitual 'Phisher' projects.");
        Deck deck = new Deck();

        deck.addInformation(TEXT, "Informacja 2");
        deck.addInformation(TEXT, "Informacja 3");
        deck.changeInformation(1,"Changed Information");
        deck.setCurrentInformation(2);
        deck.changeInformation("Another Changed Informaton");

        deck.show();

    }

}
