package exceptions;

public class EmptyStoryException extends Exception {

    public EmptyStoryException() {
        super("The content is empty.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
