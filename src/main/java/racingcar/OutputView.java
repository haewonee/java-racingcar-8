package racingcar;

import java.util.List;

public class OutputView {

    public void printRaceResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + convertPositionToHyphens(car.getPosition()));
        }
        System.out.println();
    }

    public String convertPositionToHyphens(int position) {
        StringBuilder hyphens = new StringBuilder();
        for(int i = 0; i < position; i++) {
            hyphens.append("-");
        }
        return hyphens.toString();
    }
}
