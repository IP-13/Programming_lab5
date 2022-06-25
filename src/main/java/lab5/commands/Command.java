package lab5.commands;

/**
 *  Interface for concrete command
 */
public interface Command {
    /**
     * Sets type of command
     * @param typeOfCommand
     */
    public void setTypeOfCommand(TypeOfCommand typeOfCommand);

    /**
     * Returns type of command
     * @return TypeOfCommand
     */
    public TypeOfCommand getTypeOfCommand();

    /**
     * Execute the command
     */
    public void execute();

    /**
     * Undo the command
     */
    public void undo();
}
