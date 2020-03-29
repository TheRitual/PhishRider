package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

class Deck {
    private boolean firstCard = true, firstSide = true, firstInformation = true;
    private int currentCard = 0, currentSide = 0, currentInformation = 0;
    private List<Card> cards;
    private Utils utl = new Utils(true);

    public Deck() {
        cards = new ArrayList<>();
        utl.log("Created new Deck as ArrayList of Cards");
        addCard();
    }


    public void addCard() {
        addCard(CardSideType.BASIC,InformationType.TEXT,"Default Value");
    }
    public void addCard(CardSideType cardSideType, InformationType infoType, String value) {
        Information newInfo = new Information(infoType, value);
        CardSide newCardSide = new CardSide(cardSideType);
        Card newCard = new Card();
        newCardSide.addInformation(newInfo);
        newCard.addSide(newCardSide);
        cards.add(newCard);
        currentCard = cards.size()-1;
        currentSide = 0;
        currentInformation = 0;
        utl.log("Added new Card with number [" + currentCard + "] with new CardSide (" + cardSideType + ") and information of type (" + infoType + ") value {" + value + "}");
    }

    public void addCardSide(int cardNumber, CardSideType cardSideType, InformationType infoType, String value) {
        Information newInfo = new Information(infoType, value);
        CardSide newCardSide = new CardSide(cardSideType);
        newCardSide.addInformation(newInfo);
        cards.get(cardNumber).addSide(newCardSide);
        currentCard = cardNumber;
        currentSide = cards.get(cardNumber).getSides().size()-1;
        currentInformation = 0;
        utl.log("Added new CardSide to Card number [" + currentCard + "]. New CardSide [" + currentSide + "] is of type (" + cardSideType + ") and information of type (" + infoType + ") with value {" + value + "}");
    }

    public void addCardSide(CardSideType cardSideType, InformationType informationType, String value) {
        addCardSide(currentCard, cardSideType, informationType, value);
    }

    public void addCardSide(CardSideType cardSideType) {
        addCardSide(currentCard, cardSideType, InformationType.TEXT, "Default Value");
    }

    public void addCardSide() {
        addCardSide(CardSideType.BASIC);
    }

    public void addInformation(int cardNumber, int cardSideNumber, InformationType informationType, String value) {
        cards.get(cardNumber).getSide(cardSideNumber).addInformation(informationType, value);
        currentCard = cardNumber;
        currentSide = cardSideNumber;
        currentInformation = cards.get(cardNumber).getSide(cardSideNumber).getInformationList().size()-1;
        CardSideType cardSideType = cards.get(cardNumber).getSide(cardSideNumber).getType();
        utl.log("Added new Information to Card number [" + currentCard + "], CardSide number [" + currentSide + "] with type (" + cardSideType + ") and information of type (" + informationType + ") with value {" + value + "}");
    }

    public void addInformation(int cardSideNumber, InformationType informationType, String value) {
        addInformation(currentCard, cardSideNumber, informationType, value);
    }

    public void addInformation(InformationType informationType, String value) {
        addInformation(currentSide, informationType, value);
    }

    public void addInformation(String value) {
        addInformation(currentSide, InformationType.TEXT, value);
    }

    public void addInformation() {
        addInformation("Default Value");
    }

    public void changeInformation(int cardNumber, int sideNumber, int informationNumber, InformationType type, String value) {
        InformationType oldType = cards.get(cardNumber).getSide(sideNumber).getInformation(informationNumber).getType();
        String oldValue = cards.get(cardNumber).getSide(sideNumber).getInformation(informationNumber).getValue();
        utl.log("Changed information from card " + cardNumber + " on side " + sideNumber +
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
        CardSideType oldType = cards.get(cardNumber).getSide(sideNumber).getType();
        utl.log("Changed CardSideType from card " + cardNumber + " on side " + sideNumber +
                "from TYPE (" + oldType + ") to TYPE (" + type + ")");
        cards.get(cardNumber).getSide(sideNumber).setType(type);
    }

    public void changeCardSideType(int sideNumber, CardSideType type) {
        cards.get(currentCard).getSide(sideNumber).setType(type);
    }

    public void changeCardSide(CardSideType type) {
        changeCardSideType(currentSide, type);
    }

    public void removeInformation(int cardNumber, int sideNumber, int informationNumber) {
        cards.get(cardNumber).getSide(sideNumber).getInformationList().remove(informationNumber);
    }

    public void removeInformation(int sideNumber, int infortmationNumber) {
        removeInformation(currentCard, sideNumber, infortmationNumber);
    }

    public void removeInformation(int informationNumber) {
        removeInformation(currentSide, informationNumber);
    }

    public void removeSide(int cardNumber, int sideNumber) {
        cards.get(cardNumber).getSides().remove(sideNumber);
    }

    public void removeSide(int sideNumber) {
        removeSide(currentCard, sideNumber);
    }

    public void removeCard(int cardNumber) {
        cards.remove(cardNumber);
    }

    public String current() {
        utl.log("[CARD : " + currentCard + " ] ");
        utl.log("[SIDE : " + currentSide + " ] ");
        utl.log("[INFORMATION : " + currentInformation + " ] ");
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
            utl.log("CARD[" + cardn + "] :::");
            for (CardSide side : crd.getSides()) {
                utl.log("\t SIDE[" + siden + "] (" + side.getType() + ") :::");
                int infon = 0;
                for (Information info : side.getInformationList()) {
                    utl.log("\t\t info[" + infon + "] (" + info.getType() + ") {" + info.getValue() + "}");
                    infon++;
                }
                siden++;
            }
            cardn++;
        }
    }

    public void setLog(boolean logOn) {
        this.utl.setLog(logOn);
    }
}
