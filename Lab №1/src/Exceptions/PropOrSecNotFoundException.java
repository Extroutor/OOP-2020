package Exceptions;

public class PropOrSecNotFoundException extends RuntimeException {
    public PropOrSecNotFoundException() {
    }

    public PropOrSecNotFoundException(String message) {
        super(message);
    }

    public PropOrSecNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropOrSecNotFoundException(Throwable cause) {
        super(cause);
    }
}
