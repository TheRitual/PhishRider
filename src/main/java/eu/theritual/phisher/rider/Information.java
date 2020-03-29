package eu.theritual.phisher.rider;

public class Information {
    private InformationType type;
    private String value;

    public Information(InformationType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Information() {
        //dummy constructor for JACKSON
    }

    public InformationType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    void setInformation(InformationType type, String  value) {
        this.type = type;
        this.value = value;
    }
}
