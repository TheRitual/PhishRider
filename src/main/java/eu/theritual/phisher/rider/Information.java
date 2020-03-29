package eu.theritual.phisher.rider;

class Information {
    private InformationType type;
    private String value;

    public Information(InformationType type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getInfo() {
        return value;
    }
}
