package lab5.utils;

import lab5.commands.*;

/**
 * Console
 */
public class UserConsole {
    private final Collection collection;
    private final DataScanner dataScanner;

    /**
     * Constructor
     *
     * @param collection  Collection on which operations are performed
     * @param dataScanner Scanner which will read commands from the user
     */
    public UserConsole(Collection collection, DataScanner dataScanner) {
        this.collection = collection;
        this.dataScanner = dataScanner;
    }

    /**
     * Starts console which is running until "exit" command is called
     */
    public void run() {
        System.out.println("Hello!");
        System.out.println("List of available command: ");
        executeCommand("help");
        System.out.println("Information about initial collection: ");
        executeCommand("info");
        System.out.println();
        System.out.println("Initial collection elements: ");
        executeCommand("show");
        while (dataScanner.isOpen()) {
            String currCommand = dataScanner.readCommand();
            if (executeCommand(currCommand)) {
                System.out.println();
                System.out.println("Operation " + currCommand + " was completed successfully!");
                System.out.println("Type \"help\" without quotes to see available commands.");
            } else {
                System.err.println("Unidentified command. Try again.");
            }
        }
    }

    private boolean executeCommand(String typeOfCommand) {
        AbstractCommand command = generateCommand(typeOfCommand);

        if (command != null) {
            command.setTypeOfCommand(TypeOfCommand.valueOf(typeOfCommand));
            command.execute();
            History.storeCommand(command);
            return true;
        }

        return false;
    }

    private AbstractCommand generateCommand(String typeOfCommand) {
        switch (typeOfCommand) {
            case "help" -> {
                return new Help();
            }
            case "info" -> {
                return new Info(collection);
            }
            case "show" -> {
                return new Show(collection);
            }
            case "add" -> {
                return new Add(collection, dataScanner.readTicket());
            }
            case "update" -> {
                return new Update(collection, dataScanner.readTicketId(), dataScanner.readTicket());
            }
            case "remove_by_id" -> {
                return new RemoveById(collection, dataScanner.readTicketId());
            }
            case "clear" -> {
                return new Clear(collection);
            }
            case "save" -> {
                return new Save(collection);
            }
            case "execute_script" -> {
                return new ExecuteScript(collection, dataScanner.readPath());
            }
            case "exit" -> {
                return new Exit(dataScanner);
            }
            case "remove_head" -> {
                return new RemoveHead(collection);
            }
            case "add_if_max" -> {
                return new AddIfMax(collection, dataScanner.readTicket());
            }
            case "history" -> {
                return new History();
            }
            case "average_of_discount" -> {
                return new AverageOfDiscount(collection);
            }
            case "filter_by_refundable" -> {
                return new FilterByRefundable(collection, dataScanner.readRefundable());
            }
            case "print_descending" -> {
                return new PrintDescending(collection);
            }
            default -> {
                return null;
            }
        }
    }

}
