package Exception;

public class EmptyException extends Exception {

    public EmptyException() {
        super("The content is empty.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
