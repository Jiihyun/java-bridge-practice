package bridge2.view;

import bridge2.domain.BridgeGameResult;
import bridge2.domain.MoveRecords;

public class OutputView {
    public void printMap(final MoveRecords moveRecords) {
        System.out.println(moveRecords);
    }

    public void printResult(final BridgeGameResult gameResult) {
        System.out.println(gameResult);
    }
}
