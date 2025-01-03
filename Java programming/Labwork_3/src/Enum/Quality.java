package Enum;

public enum Quality {
    LOVELY("любимую"),
    GOOD("хорошая"),
    BEAUTIFUL("красивей"),
    EVERY("каждым"),
    LONG("долгое"),
    YOURS("свой");

    private final String description;

    Quality(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
