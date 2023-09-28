package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.MapResult;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();
        MapResult mapResult = new MapResult();
        BridgeController bridgeController = new BridgeController(inputView,outputView, bridgeMaker, bridgeGame, mapResult);
        bridgeController.start();

    }
}
