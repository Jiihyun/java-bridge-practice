package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.MapResult;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.utils.MessageConst;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.MessageConst.*;

public class BridgeController {
    InputView inputView;
    OutputView outputView;
    BridgeNumberGenerator bridgeNumberGenerator;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;
    MapResult mapResult;

    public BridgeController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator, BridgeMaker bridgeMaker, BridgeGame bridgeGame, MapResult mapResult) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
        this.mapResult = mapResult;
    }

    public void start() {
        int bridgeSize = getBridgeSize();
        List<String> correctRoute = bridgeMaker.makeBridge(bridgeSize);
        List<String> userDirections = movePosition(bridgeSize, correctRoute);
        int count = 1;
        while (!userDirections.equals(correctRoute)) {
            outputView.printInputRestartOrNotMsg();
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) {
                break;
            }
            count++;
            userDirections = movePosition(bridgeSize, correctRoute);
        }
        System.out.println(GAME_RESULT_MSG);
        outputView.printMap(mapResult, userDirections, correctRoute);
        outputView.printResult(count, userDirections, correctRoute);
    }

    private int getBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private List<String> movePosition(int bridgeSize, List<String> correctRoute) {
        List<String> directions = new ArrayList<>();
        int i = 0;
        while (directions.size() < bridgeSize) {
            String direction = inputView.readMoving();
            directions.add(direction);
            outputView.printMap(mapResult, directions, correctRoute);

            if (!direction.equals(correctRoute.get(i))) {
                break;
            }
            i++;
        }
        return directions;
    }


}
