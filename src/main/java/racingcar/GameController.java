package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    public void run() {
        List<Car> cars = createCarsFromUserInput();
        int tryCount = getTryCountFromUserInput();

        runRace(cars, tryCount);

        List<String> winners = findWinners(cars);
        outputView.printWinners(winners);
    }

    private List<Car> createCarsFromUserInput() {
        String namesInput = inputView.readCarNames();
        String[] carNames = namesInput.split(",");
        validator.validateCarNames(carNames); // 유효성 검사

        return Arrays.stream(carNames)
                .map(Car::new) // Car::new는 Car(String name) 생성자를 의미
                .collect(Collectors.toList());
    }

    private int getTryCountFromUserInput() {
        String tryCountInput = inputView.readTryCount();
        validator.validateTryCount(tryCountInput); // 유효성 검사

        return Integer.parseInt(tryCountInput);
    }

    private void runRace(List<Car> cars, int tryCount) {
        outputView.printRaceResultHeader();
        for (int i = 0; i < tryCount; i++) {
            moveAllCars(cars);
            outputView.printRoundResult(cars);
        }
    }

    private void moveAllCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }


}
