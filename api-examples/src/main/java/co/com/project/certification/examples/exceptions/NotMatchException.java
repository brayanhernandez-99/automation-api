package co.com.project.certification.examples.exceptions;

public class NotMatchException extends AssertionError {

    public NotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}