package bridge3.controller;

import bridge3.domain.BridgeMaker;
import bridge3.view.InputView;
import bridge3.view.OutputView;

import java.util.List;

public class MainController {
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public MainController(OutputView outputView, InputView inputView, BridgeMaker bridgeMaker) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void start() {
        //입력
        makeBridgeRoute();
        //실행 (이동할 칸 선택 후 출력 / 틀리면 retry or not)
        //결과 출력 (최종 게임 결과 출력, 게임 성공여부 & 총 시도 횟수 출력)
    }

    private void makeBridgeRoute() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeRoute = bridgeMaker.makeBridge(bridgeSize);
    }
}
