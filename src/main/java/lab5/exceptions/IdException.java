package lab5.exceptions;

/**
 * Thrown when in the original file contains multiple tickets with same ID
 */
public class IdException extends IllegalArgumentException {
    public IdException(String message) {
        super(message);
    }
}
