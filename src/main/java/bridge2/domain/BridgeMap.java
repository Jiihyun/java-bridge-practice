package bridge2.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final List<MovePosition> movePositions;

    private BridgeMap(final List<MovePosition> movePositions) {
        this.movePositions = movePositions;
    }

    //imp - look it up more!!
    public static BridgeMap from(final List<String> values) {
        final ArrayList<MovePosition> movePositions = new ArrayList<>();
        for (final String value : values) {
            movePositions.add(MovePosition.of(value ));
        }
        return new BridgeMap(movePositions);
    }

    public boolean isSameMovePositionAt(final int index, final MovePosition movePosition) {
        return movePositions.get(index).equals(movePosition);
    }

    public boolean isEndOfBridge(final int index) {
        return index == movePositions.size()-1;
    }
}
