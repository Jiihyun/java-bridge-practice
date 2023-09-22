package bridge.domain;

import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MapResult {

    public String getMapResult(List<String> directions, List<String> correctRoute) {
        List<String> upperList = new ArrayList<>();
        List<String> lowerList = new ArrayList<>();
        for (int i = 0; i < directions.size(); i++) {
            if (directions.get(i).equals(correctRoute.get(i))) {
                //directions.get(i)의 방향 U, D에 따라 지도 표시해주기
                if (directions.get(i).equals("U")) {
                    upperList.add(i, "O");
                    lowerList.add(i, " ");
                }
                if (directions.get(i).equals("D")) {
                    lowerList.add(i, "O");
                    upperList.add(i, " ");
                }
            }
            if (!directions.get(i).equals(correctRoute.get(i))) {

                if (directions.get(i).equals("U")) {
                    upperList.add(i, "X");
                    lowerList.add(i, " ");
                }
                if (directions.get(i).equals("D")) {
                    lowerList.add(i, "X");
                    upperList.add(i, " ");
                }
                break;
            }
        }

        String upper = String.join(" | ", upperList);
        String lower = String.join(" | ", lowerList);
        return String.format("[ %s ]\n[ %s ]\n", upper, lower);
    }
}
