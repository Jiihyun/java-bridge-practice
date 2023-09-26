package bridge2.controller;

import bridge2.domain.BridgeMaker;
import bridge2.domain.BridgeMap;
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
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeRoute = bridgeMaker.makeBridge(bridgeSize);
        BridgeMap bridgeMap = BridgeMap.from(bridgeRoute); //위의 List<String>을 List<MovePosition>으로 변환
    }
}
