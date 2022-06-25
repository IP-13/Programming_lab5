package lab5.commands;

import lab5.utils.Collection;

/**
 * FilterByRefundable class represents concrete command that displays items whose refundable field value is equal to the given one
 */
public class FilterByRefundable extends AbstractCommand {
    private final Collection collection;
    private final boolean isRefundable;

    /**
     * Constructor
     * @param isRefundable Value to filter the collection
     */
    public FilterByRefundable(Collection collection, boolean isRefundable) {
        this.collection = collection;
        this.isRefundable = isRefundable;
    }

    /**
     * Displays items whose refundable field value is equal to the given one
     */
    @Override
    public void execute() {
        collection.getPriorityQueue().stream().
                filter(ticket -> ticket.isRefundable() == isRefundable).
                forEach(ticket-> System.out.println(ticket.toString()));
    }

    @Override
    public void undo() {

    }
}
