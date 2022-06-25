package lab5.commands;

import lab5.utils.DataScanner;

/**
 * Exit class represents concrete command that exits the program (without saving to a file)
 */
public class Exit extends AbstractCommand {
    private final DataScanner dataScanner;

    /**
     * Constructor
     * @param dataScanner Scanner which will be closed before exiting the program
     */
    public Exit(DataScanner dataScanner) {
        this.dataScanner = dataScanner;
    }

    /**
     * Exits that program (without saving to a file)
     */
    @Override
    public void execute() {
        dataScanner.getScanner().close();
        dataScanner.setOpen(false);
    }

    @Override
    public void undo() {

    }
}
