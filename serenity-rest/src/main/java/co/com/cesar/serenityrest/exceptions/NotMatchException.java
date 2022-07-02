package co.com.cesar.serenityrest.exceptions;

public class NotMatchException extends AssertionError {

    public NotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}