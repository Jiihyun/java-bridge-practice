package bridge2.controller;

import bridge2.domain.*;
import bridge2.view.InputView;
import bridge2.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public GameController(
            final InputView inputView,
            final OutputView outputView,
            final BridgeMaker bridgeMaker
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void start() {
        final BridgeGame bridgeGame = makeBridgeGame();
        play(bridgeGame);
        outputView.printResult(bridgeGame.getGameResult());
    }

    private BridgeGame makeBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeRoute = bridgeMaker.makeBridge(bridgeSize);
        BridgeMap bridgeMap = BridgeMap.from(bridgeRoute); //위의 List<String>을 List<MovePosition>으로 변환
        return BridgeGame.of(bridgeMap);
    }

    private void play(BridgeGame bridgeGame) {
        while (bridgeGame.isPlaying()) {
            final String movePositionString = inputView.readMoving();
            final MovePosition movePosition = MovePosition.of(movePositionString);
            bridgeGame.move(movePosition);
            MoveRecords moveRecords = bridgeGame.getMoveRecords();
            outputView.printMap(moveRecords);
        }
        retryIfFailed(bridgeGame);
    }

    private void retryIfFailed(BridgeGame bridgeGame) {
        if (bridgeGame.isFailed()) {
            final String gameCommand = inputView.readGameCommand();
            if ("R".equals(gameCommand)) {
                bridgeGame.retry();
                play(bridgeGame);
            }
        }
    }
}
