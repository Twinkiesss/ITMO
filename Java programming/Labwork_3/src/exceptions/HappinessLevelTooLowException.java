package exceptions;

public class HappinessLevelTooLowException extends Exception {
    private final int minCounter;

    public HappinessLevelTooLowException(int minCounter) {
        super("Minimum happiness level reached. Min Counter: " + minCounter);
        this.minCounter = minCounter;
    }

    public int getMinCounter() {
        return minCounter;
    }
}