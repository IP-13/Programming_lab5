package lab5.commands;

import lab5.exceptions.ExecuteScriptException;
import lab5.exceptions.RecursionInScriptException;
import lab5.utils.Collection;
import lab5.utils.ScriptScanner;
import lab5.utils.UserConsole;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ExecuteScript class represents concrete command that reads and executes script from specified file.
 * The script contains commands in the same form in which they are entered by the user in interactive mode.
 */
public class ExecuteScript extends AbstractCommand {
    private final Collection collection;
    private final String scriptPath;
    private static final ArrayList<String> scriptsPaths = new ArrayList<>();

    /**
     * Constructor
     *
     * @param scriptPath Path to the script
     */
    public ExecuteScript(Collection collection, String scriptPath) {
        this.collection = collection;
        this.scriptPath = scriptPath;
    }

    /**
     * Reads and executes script from specified file.
     * The script contains commands in the same form in which they are entered by the user in interactive mode.
     */
    @Override
    public void execute() {
        try {
            if (scriptsPaths.contains(scriptPath)) {
                throw new RecursionInScriptException("Recursion. Script " + scriptPath + " calls itself back");
            }
            scriptsPaths.add(scriptPath);
            ScriptScanner scriptScanner = new ScriptScanner(new Scanner(new FileReader(scriptPath)));
            UserConsole userConsole = new UserConsole(collection, scriptScanner);
            userConsole.run();
        } catch (FileNotFoundException e) {
            System.err.println("No Such File");
        } catch (InputMismatchException e) {
            throw new ExecuteScriptException("" +
                    "Something wrong with your script. " +
                    "Check for \"exit\" command in the end of the script and try again");
        } catch (RecursionInScriptException e) {
            throw new RecursionInScriptException("Script " + scriptPath + " calls itself back");
        }
        scriptsPaths.remove(scriptPath);
    }

    @Override
    public void undo() {

    }
}
