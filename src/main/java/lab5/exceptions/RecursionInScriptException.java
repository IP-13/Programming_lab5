package lab5.exceptions;

/**
 * Thrown when scripts create recursion
 */
public class RecursionInScriptException extends RuntimeException {
    public RecursionInScriptException(String message) {
        super(message);
    }
}
