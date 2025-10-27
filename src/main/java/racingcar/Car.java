package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
}
