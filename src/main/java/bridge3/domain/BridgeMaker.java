package bridge3.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeAnswer = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addDirection(bridgeAnswer);
        }
        return bridgeAnswer;
    }

    private void addDirection(List<String> bridgeAnswer) {
        int direction = bridgeNumberGenerator.generate();
        if (direction == 0) {
            bridgeAnswer.add("D");
        }
        if (direction == 1) {
            bridgeAnswer.add("U");
        }
    }
}
