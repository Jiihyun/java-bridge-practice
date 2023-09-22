package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.MessageConst.*;
import static bridge.utils.NumberConst.BRIDGE_LENGTH_EXCLUSIVE;
import static bridge.utils.NumberConst.BRIDGE_LENGTH_INCLUSIVE;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printInputBridgeSizeMsg();
        String size = Console.readLine();
        for (int i = 0; i < size.length(); i++) {
            if (!Character.isDigit(size.charAt(i))) {
                throw new IllegalArgumentException(BRIDGE_SIZE_EXCEPTION);
            }
        }
        int bridgeSize = Integer.parseInt(size);
        if (bridgeSize < BRIDGE_LENGTH_INCLUSIVE || bridgeSize > BRIDGE_LENGTH_EXCLUSIVE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_EXCEPTION);
        }

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printInputMovePositionMsg();
        String moving = Console.readLine();
        if (!"U".equals(moving) && !"D".equals(moving)) {
            throw new IllegalArgumentException(MOVING_CHOICE_EXCEPTION);
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        if (!"R".equals(gameCommand) && !"Q".equals(gameCommand)) {
            throw new IllegalArgumentException(GAME_COMMAND_EXCEPTION);
        }
        return gameCommand;
    }
}
