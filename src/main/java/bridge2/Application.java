package bridge2;

import bridge2.controller.GameController;
import bridge2.domain.BridgeMaker;
import bridge2.utils.BridgeNumberGenerator;
import bridge2.utils.BridgeRandomNumberGenerator;
import bridge2.view.InputView;
import bridge2.view.OutputView;

public class Application {
    public static void main(String[] args) {
    InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        GameController gameController = new GameController(inputView, outputView, bridgeMaker);
        gameController.start();

    }
}
