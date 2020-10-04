package Exceptions;

public class NotFoundOrInvalidFileException extends RuntimeException{
    public NotFoundOrInvalidFileException() {
    }

    public NotFoundOrInvalidFileException(String message) {
        super(message);
    }

    public NotFoundOrInvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundOrInvalidFileException(Throwable cause) {
        super(cause);
    }
}
