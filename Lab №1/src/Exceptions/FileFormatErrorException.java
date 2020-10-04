package Exceptions;

public class FileFormatErrorException extends RuntimeException {
    public FileFormatErrorException() {
    }

    public FileFormatErrorException(String message) {
        super(message);
    }

    public FileFormatErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileFormatErrorException(Throwable cause) {
        super(cause);
    }
}
