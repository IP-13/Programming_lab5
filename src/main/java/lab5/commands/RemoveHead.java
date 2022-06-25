package lab5.commands;

import lab5.storedClasses.Ticket;
import lab5.utils.Collection;

/**
 * RemoveHead class represents concrete command that outputs the first element of the collection and remove it
 */
public class RemoveHead extends AbstractCommand {
    private final Collection collection;
    private Ticket head;

    /**
     * Constructor
     */
    public RemoveHead(Collection collection) {
        this.collection = collection;
    }

    /**
     * Outputs the first element of the collection and remove it
     */
    @Override
    public void execute() {
        head = collection.getPriorityQueue().poll();
    }

    /**
     * Returns removed element back to the collection
     */
    @Override
    public void undo() {
        collection.getPriorityQueue().add(head);
    }
}
