package lab5.commands;

import java.util.ArrayDeque;

/**
 * History class represents concrete command that prints the last 11 commands (without their arguments)
 */
public class History extends AbstractCommand {
    private static final ArrayDeque<Command> commandHistory = new ArrayDeque<>(11);

    /**
     * Static method which stores commands
     * @param command Command which will be stored
     */
    public static void storeCommand(Command command) {
        if (commandHistory.size() >= 11) {
            commandHistory.removeFirst();
        }
        commandHistory.addLast(command);
    }

    /**
     * Prints the last 11 commands (without their arguments)
     */
    @Override
    public void execute() {
        System.out.println("Command history: ");
        commandHistory.stream().forEachOrdered(t-> System.out.println(t.getTypeOfCommand()));
    }

    @Override
    public void undo() {

    }
}
