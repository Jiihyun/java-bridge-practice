package bridge2.domain;

import bridge.domain.BridgeMaker;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMap bridgeMap;
    private final MoveRecords moveRecords;
    private int attemptCount = 1;

    private BridgeGame(final BridgeMap bridgeMap) {
        this.bridgeMap = bridgeMap;
        this.moveRecords = MoveRecords.create();
    }

    public static BridgeGame of(final BridgeMap bridgeMap) {
        return new BridgeGame(bridgeMap);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> userMoving) {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
