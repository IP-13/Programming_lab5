package lab5.exceptions;

import java.util.InputMismatchException;

/**
 * Thrown when the script is incorrect
 */
public class ExecuteScriptException extends InputMismatchException {
    public ExecuteScriptException(String message) {
        super(message);
    }
}
