package racingcar;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 1;

    public void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            validateNameLength(name);
            validateNameIsNotBlank(name);
        }
    }

    public void validateTryCount(String tryCountInput) {
        int tryCount = validateIsNumber(tryCountInput);
        validateIsPositive(tryCount);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateNameIsNotBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private int validateIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateIsPositive(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
