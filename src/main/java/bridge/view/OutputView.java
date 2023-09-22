package bridge.view;

import bridge.domain.MapResult;
import bridge.utils.MessageConst;

import java.util.List;

import static bridge.utils.MessageConst.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapResult result, List<String> directions, List<String> correctRoute) {
        String mapResult = result.getMapResult(directions, correctRoute);
        System.out.println(mapResult);


    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, List<String> directions, List<String> correctRoute) {
        if (!correctRoute.equals(directions)) {
            System.out.println("게임 성공 여부: 실패");
        }
        if (correctRoute.equals(directions)) {
            System.out.println("게임 성공 여부: 성공");
        }
        System.out.println("총 시도한 횟수: " + count);

    }

    public void printInputBridgeSizeMsg() {
        System.out.println(GAME_START_MSG);
        System.out.println(INPUT_BRIDGE_SIZE_MSG);
    }

    public void printInputMovePositionMsg() {
        System.out.println(INPUT_MOVE_DIRECTION_MSG);
    }

    public void printInputRestartOrNotMsg() {
        System.out.println(GAME_RESTART_MSG);
    }
}
