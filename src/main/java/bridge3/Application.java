package bridge3;

import bridge3.controller.MainController;
import bridge3.domain.BridgeMaker;
import bridge3.domain.BridgeRandomNumberGenerator;
import bridge3.view.InputView;
import bridge3.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        MainController mainController = new MainController(outputView, inputView, bridgeMaker);
        mainController.start();
    }
}
