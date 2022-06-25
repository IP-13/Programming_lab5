package lab5.commands;

import lab5.storedClasses.Ticket;
import lab5.utils.Collection;

/**
 * Add class represents concrete command that adds a new element to the collection
 */
public class Add extends AbstractCommand {
    private final Collection collection;
    private final Ticket addTicket;

    /**
     * Constructor
     * @param collection collection where the ticket will be added
     * @param addTicket ticket that will be added
     */
    public Add(Collection collection, Ticket addTicket) {
        this.collection = collection;
        this.addTicket = addTicket;
    }

    /**
     * Adds a new element to the collection
     */
    @Override
    public void execute() {
        collection.getPriorityQueue().add(addTicket);
    }

    /**
     * Delete added ticket from the collection
     */
    @Override
    public void undo() {
        collection.getPriorityQueue().remove(addTicket);
    }
}
