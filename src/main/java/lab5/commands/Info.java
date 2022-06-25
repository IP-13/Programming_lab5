package lab5.commands;

import lab5.utils.Collection;

/**
 * Info class represents concrete command that prints information about the collection to standard output (type, initialization date, number of elements, etc.)
 */
public class Info extends AbstractCommand {
    private final Collection collection;

    /**
     * Constructor
     */
    public Info(Collection collection) {
        this.collection = collection;
    }

    /**
     * Prints information about the collection to standard output (type, initialization date, number of elements, etc.)
     */
    @Override
    public void execute() {
        System.out.println("Class: " + collection.getClass());
        System.out.println("Initialization Date: " + collection.getInitializationDate());
        System.out.println("Size: " + collection.getPriorityQueue().size());
    }

    @Override
    public void undo() {

    }
}
