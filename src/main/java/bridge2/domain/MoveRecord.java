package bridge2.domain;

public enum MoveRecord {
    O("O"),
    X("X"),
    NONE(" ");

    private final String value;

    MoveRecord(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
