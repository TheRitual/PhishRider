package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

class CardSide {
    private CardSideType type;
    private List<Information> informationList;

    CardSide(CardSideType type) {
        informationList = new ArrayList<>();
        this.type = type;
    }

    List<Information> getInformationList() {
        return informationList;
    }

    Information getInformation(int number) {
        return informationList.get(number);
    }

    void addInformation(InformationType type, String value) {
        informationList.add(new Information(type,value));
    }

    CardSideType getType() {
        return type;
    }

    public void setType(CardSideType type) {
        this.type = type;
    }
}
