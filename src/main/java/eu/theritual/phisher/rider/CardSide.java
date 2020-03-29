package eu.theritual.phisher.rider;

import java.util.List;

class CardSide {
    private List<Information> informationList;
    public CardSide(List<Information> informationList) {
        this.informationList = informationList;
    }

    public List<Information> getInformationList() {
        return informationList;
    }
}
