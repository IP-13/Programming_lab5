package lab5.commands;

import lab5.storedClasses.Ticket;
import lab5.utils.Collection;

/**
 *  AverageOfDiscount class represents concrete command that displays the average value of the discount field for all items in the collection
 */
public class AverageOfDiscount extends AbstractCommand {
    private final Collection collection;

    /**
     * Constructor
     */
    public AverageOfDiscount(Collection collection) {
        this.collection = collection;
    }

    /**
     * Outputs average of discount
     */
    @Override
    public void execute() {
        long sum = 0;
        for (Ticket t: collection.getPriorityQueue()) {
            sum += t.getDiscount();
        }
        System.out.println("Average of discount: " + sum / collection.getPriorityQueue().size());
    }

    @Override
    public void undo() {

    }
}
