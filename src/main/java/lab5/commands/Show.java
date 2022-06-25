package lab5.commands;

import lab5.utils.Collection;

/**
 * Show class represents concrete command that prints to standard output all elements of the collection in string representation
 */
public class Show extends AbstractCommand {
    private final Collection collection;

    /**
     * Constructor
     */
    public Show(Collection collection) {
        this.collection = collection;
    }

    /**
     * Prints to standard output all elements of the collection in string representation
     */
    @Override
    public void execute() {
        collection.getPriorityQueue().forEach(ticket -> System.out.println(ticket.toString()));
    }

    @Override
    public void undo() {

    }
}
