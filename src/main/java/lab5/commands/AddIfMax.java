package lab5.commands;

import lab5.storedClasses.Ticket;
import lab5.utils.Collection;

/**
 * AddIfMax class represents concrete command that adds a new element to the collection if its value is greater than the value of the largest element in this collection
 */
public class AddIfMax extends AbstractCommand {
    private final Collection collection;
    private final Ticket maxTicket;

    /**
     * Constructor
     * @param collection Collection where the ticket will be added
     * @param maxTicket Ticket that will be added
     */
    public AddIfMax(Collection collection, Ticket maxTicket) {
        this.collection = collection;
        this.maxTicket = maxTicket;
    }

    /**
     * Adds a new element to the collection if its value is greater than the value of the largest element in this collection
     */
    @Override
    public void execute() {
        if (collection.getPriorityQueue().stream().allMatch(t -> t.hashCode() < maxTicket.hashCode())) {
            collection.getPriorityQueue().add(maxTicket);
        }
        else {
            System.out.println("Element was not added");
        }
    }

    /**
     * Delete added ticket from the collection
     */
    @Override
    public void undo() {
        collection.getPriorityQueue().remove(maxTicket);
    }
}
