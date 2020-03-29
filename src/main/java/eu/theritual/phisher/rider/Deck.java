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

    public void changeInformation(int cardNumber, int sideNumber, int informationNumber, InformationType type, String value) {
        InformationType oldType = cards.get(cardNumber).getSide(sideNumber).getInformation(informationNumber).getType();
        String oldValue = cards.get(cardNumber).getSide(sideNumber).getInformation(informationNumber).getValue();
        Utils.logS("Changed information from card " + cardNumber + " on side " + sideNumber +
                " from TYPE (" + oldType + ") and VALUE {" + oldValue + "}" +
                " to TYPE (" + type + ") and VALUE {" + value + "}");
        cards.get(cardNumber).getSide(sideNumber).getInformation(informationNumber).setInformation(type, value);
    }

    public void changeInformation(int sideNumber, int informationNumber, InformationType type, String value) {
        changeInformation(currentCard, sideNumber, informationNumber, type, value);
    }

    public void changeInformation(int informationNumber, InformationType type, String value) {
        changeInformation(currentCard, currentSide, informationNumber, type, value);
    }

    public void changeInformation(InformationType type, String value) {
        changeInformation(currentCard, currentSide, currentInformation, type, value);
    }

    public void changeInformation(int informationNumber, String value) {
        InformationType oldType = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getType();
        changeInformation(currentCard, currentSide, informationNumber, oldType, value);
    }

    public void changeInformation(InformationType type) {
        String oldValue = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getValue();
        changeInformation(currentCard, currentSide, currentInformation, type, oldValue);
    }

    public void changeInformation(String value) {
        InformationType oldType = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getType();
        changeInformation(currentCard, currentSide, currentInformation, oldType, value);
    }

    public void changeInformation(int informationNumber, InformationType type) {
        String oldValue = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getValue();
        changeInformation(currentCard, currentSide, informationNumber, type, oldValue);
    }

    public void changeInformation(int sideNumber, int informationNumber, String value) {
        InformationType oldType = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getType();
        changeInformation(currentCard, sideNumber, informationNumber, oldType, value);
    }

    public void changeInformation(int sideNumber, int informationNumber, InformationType type) {
        String oldValue = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getValue();
        changeInformation(currentCard, sideNumber, informationNumber, type, oldValue);
    }

    public void changeInformation(int cardNumber, int sideNumber, int informationNumber, String value) {
        InformationType oldType = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getType();
        changeInformation(cardNumber, sideNumber, informationNumber, oldType, value);
    }

    public void changeInformation(int cardNumber, int sideNumber, int informationNumber, InformationType type) {
        String oldValue = cards.get(currentCard).getSide(currentSide).getInformation(currentInformation).getValue();
        changeInformation(cardNumber, sideNumber, informationNumber, type, oldValue);
    }

    public void changeCardSideType(int cardNumber, int sideNumber, CardSideType type) {
        cards.get(cardNumber).getSide(sideNumber).setType(type);
    }

    public void changeCardSideType(int number, CardSideType type) {
        cards.get(currentCard).getSide(number).setType(type);
    }

    public void changeCardSide(CardSideType type) {
        changeCardSideType(currentSide, type);
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

    public String current() {
        System.out.print("[CARD : " + currentCard + " ] ");
        System.out.print("[SIDE : " + currentSide + " ] ");
        System.out.println("[INFORMATION : " + currentInformation + " ] ");
        return  currentCard + "|" + currentSide + "|" + currentInformation;
    }

    public int getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(int currentCard) {
        this.currentCard = currentCard;
        setCurrentSide(0);
    }

    public int getCurrentSide() {
        return currentSide;
    }

    public void setCurrentSide(int currentSide) {
        this.currentSide = currentSide;
        setCurrentInformation(0);
    }

    public int getCurrentInformation() {
        return currentInformation;
    }

    public void setCurrentInformation(int currentInformation) {
        this.currentInformation = currentInformation;
    }
    
    public void show() {
        int cardn = 0;
        for (Card crd : cards) {
            int siden = 0;
            System.out.println("CARD[" + cardn + "] :::");
            for (CardSide side : crd.getSides()) {
                System.out.println("\t SIDE[" + siden + "] (" + side.getType() + ") :::");
                int infon = 0;
                for (Information info : side.getInformationList()) {
                    System.out.println("\t\t info[" + infon + "] (" + info.getType() + ") {" + info.getValue() + "}");
                    infon++;
                }
                siden++;
            }
            cardn++;
        }
    }
}
