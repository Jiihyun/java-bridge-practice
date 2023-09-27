package bridge2.domain;

public enum MovePosition {
    UP("U"),
    DOWN("D");

    private final String value;

    MovePosition(final String value) {
        this.value = value;
    }

    public static MovePosition of(final String value) {
        if ("U".equals(value)) {
            return MovePosition.UP;
        }
        if ("D".equals(value)) {
            return MovePosition.DOWN;
        }
        throw new IllegalArgumentException();
    }

    public MovePosition getOpposite() {
        if (UP.equals(this)) {
            return DOWN;
        }
        return UP;
    }
}
