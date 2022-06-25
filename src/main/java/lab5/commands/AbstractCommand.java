package lab5.commands;

/**
 * Abstract class that represents all concrete commands
 */
public abstract class AbstractCommand implements Command {
    /**
     * Protected field that defines type of current command
     */
    protected TypeOfCommand typeOfCommand = null;

    /**
     * Sets type of command
     * @param typeOfCommand
     */
    @Override
    public void setTypeOfCommand(TypeOfCommand typeOfCommand) {
        this.typeOfCommand = typeOfCommand;
    }

    /**
     * Returns type of command
     * @return TypeOfCommand
     */
    @Override
    public TypeOfCommand getTypeOfCommand() {
        return typeOfCommand;
    }

    /**
     * Abstract method that executes command
     */
    @Override
    public abstract void execute();

    /**
     * Abstract method that undoes the command
     */
    @Override
    public abstract void undo();
}
