package bridge.domain;

import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MapResult {

    List<String> upperList;
    List<String> lowerList;

    public String getMapResult(List<String> directions, List<String> correctRoute) {
        this.upperList =  new ArrayList<String>();
        this.lowerList = new ArrayList<String>();
        for (int i = 0; i < directions.size(); i++) {
            rightDirection(directions, correctRoute, i);
            if (wrongDirection(directions, correctRoute, i)) {
                break;
            }
        }
        String upper = String.join(" | ", upperList);
        String lower = String.join(" | ", lowerList);
        return String.format("[ %s ]\n[ %s ]\n", upper, lower);
    }

    private boolean wrongDirection(List<String> directions, List<String> correctRoute, int i) {
        if (!directions.get(i).equals(correctRoute.get(i)) && directions.get(i).equals("U")) {
            upperList.add(i, "X");
            lowerList.add(i, " ");
            return true;
        }
        if (!directions.get(i).equals(correctRoute.get(i)) && directions.get(i).equals("D")) {
            lowerList.add(i, "X");
            upperList.add(i, " ");
            return true;
        }
        return false;
    }

    private void rightDirection(List<String> directions, List<String> correctRoute, int i) {
        if (directions.get(i).equals(correctRoute.get(i)) && directions.get(i).equals("U")) {
            upperList.add(i, "O");
            lowerList.add(i, " ");
        }
        if (directions.get(i).equals(correctRoute.get(i)) && directions.get(i).equals("D")) {
            lowerList.add(i, "O");
            upperList.add(i, " ");
        }
    }
}
