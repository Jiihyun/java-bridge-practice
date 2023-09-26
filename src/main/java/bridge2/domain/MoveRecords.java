package bridge2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveRecords {
    private final Map<MovePosition, List<MoveRecord>> moveRecordsMap;

    private MoveRecords(final Map<MovePosition, List<MoveRecord>> moveRecordsMap) {
        this.moveRecordsMap = moveRecordsMap;
    }

    public static MoveRecords create() {
        final Map<MovePosition, List<MoveRecord>> movePositionsMap = new HashMap<>();
        movePositionsMap.put(MovePosition.UP, new ArrayList<>());
        movePositionsMap.put(MovePosition.DOWN, new ArrayList<>());

        return new MoveRecords(movePositionsMap);
    }

    public void record(final MovePosition movePosition, final MoveRecord moveRecord) {

    }
}
