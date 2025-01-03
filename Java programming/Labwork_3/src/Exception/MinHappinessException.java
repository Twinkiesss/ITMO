package Exception;

public class MinHappinessException extends Exception {
    private final int minCounter;

    public MinHappinessException(int minCounter) {
        super("Minimum happiness level reached. Min Counter: " + minCounter);
        this.minCounter = minCounter;
    }

    public int getMinCounter() {
        return minCounter;
    }
}