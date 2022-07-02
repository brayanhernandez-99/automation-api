package in.reqres.exceptions;

public class NotMatchException extends AssertionError {

    public NotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}