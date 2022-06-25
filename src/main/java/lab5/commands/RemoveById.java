package lab5.commands;

import lab5.storedClasses.Ticket;
import lab5.utils.Collection;

/**
 * RemoveById class represents concrete command that removes an element from the collection by its id
 */
public class RemoveById extends AbstractCommand {
    private final Collection collection;
    private final Long id;
    private Ticket ticket;

    /**
     * Constructor
     * @param id Id of element to delete
     */
    public RemoveById(Collection collection, Long id) {
        this.collection = collection;
        this.id = id;
    }

    /**
     * Removes an element from the collection by its id
     */
    @Override
    public void execute() {
        for (Ticket t : collection.getPriorityQueue()) {
            if (t.getId().equals(id)) {
                ticket = t.clone();
                collection.getPriorityQueue().remove(t);
                break;
            }
        }
    }

    /**
     * Returns removed element back to the collection
     */
    @Override
    public void undo() {
        collection.getPriorityQueue().add(ticket);
    }
}
