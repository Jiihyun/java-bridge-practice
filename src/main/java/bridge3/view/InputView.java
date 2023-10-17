package bridge3.view;

import bridge3.util.MessageConst;
import camp.nextstep.edu.missionutils.Console;

import static bridge3.util.MessageConst.*;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readBridgeSize() {
        outputView.printInputBridgeLengthMsg();
        String bridgeSizeStr = readConsole();
        validateBridgeSizeFormat(bridgeSizeStr);
        int bridgeSize = Integer.parseInt(bridgeSizeStr);
        validageBridgeSize(bridgeSize);
        return bridgeSize;
    }

    private void validageBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_EXCEPTION);
        }
    }

    private void validateBridgeSizeFormat(String bridgeSizeStr) {
        for (int i = 0; i < bridgeSizeStr.length(); i++) {
            if (!Character.isDigit(bridgeSizeStr.charAt(i))) {
                throw new IllegalArgumentException(BRIDGE_SIZE_WRONG_FORMAT_EXCEPTION);
            }
        }
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }

    private String readConsole() {
        return Console.readLine();
    }
}
