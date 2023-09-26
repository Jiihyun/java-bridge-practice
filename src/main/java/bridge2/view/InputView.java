package bridge2.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        return Integer.parseInt(readLine());
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
