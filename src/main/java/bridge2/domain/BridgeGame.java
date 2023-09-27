package bridge2.domain;

import bridge.domain.BridgeMaker;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMap bridgeMap;
    private MoveRecords moveRecords;
    private int attemptCount = 1;
    private int nextIndexAtBridge = 0;
    private BridgeGameStatus status = BridgeGameStatus.PLAYING;

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
    private MoveRecord getMoveRecord(final MovePosition movePosition) {
        if (bridgeMap.isSameMovePositionAt(nextIndexAtBridge, movePosition)) {
            return MoveRecord.O;
        }
        return MoveRecord.X;
    }

    public void move(final MovePosition movePosition) {
        MoveRecord moveRecord = getMoveRecord(movePosition);
        if (MoveRecord.X.equals(moveRecord)) {
            status = BridgeGameStatus.FAILURE;
        }
        if (bridgeMap.isEndOfBridge(nextIndexAtBridge++)) {
            status = BridgeGameStatus.CLEAR;
        }
        moveRecords.record(movePosition, moveRecord);
    }

    public boolean isPlaying() {
        return status.equals(BridgeGameStatus.PLAYING);
    }

    public boolean isFailed() {
        return status.equals(BridgeGameStatus.FAILURE);
    }

    public MoveRecords getMoveRecords() {
        return moveRecords;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        moveRecords = MoveRecords.create();
        nextIndexAtBridge = 0;
        status = BridgeGameStatus.PLAYING;
        attemptCount++;
    }

    public BridgeGameResult getGameResult() {
        return BridgeGameResult.of(attemptCount, isFailed(), moveRecords);
    }
}
