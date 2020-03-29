package eu.theritual.phisher.rider;

import java.util.ArrayList;
import java.util.List;

public class CardSide {
    private CardSideType type;
    private List<Information> informationList;

    public CardSide(CardSideType type) {
        informationList = new ArrayList<>();
        this.type = type;
    }

    public CardSide() {
        //dummy constructor for Jackson
    }

    public List<Information> getInformationList() {
        return informationList;
    }

    Information getInformation(int number) {
        return informationList.get(number);
    }

    void addInformation(InformationType type, String value) {
        informationList.add(new Information(type,value));
    }

    void addInformation(Information info) {
        informationList.add(info);
    }

    public CardSideType getType() {
        return type;
    }

    public void setType(CardSideType type) {
        this.type = type;
    }
}
