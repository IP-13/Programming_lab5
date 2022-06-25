package lab5.commands;

import lab5.utils.Collection;
import java.util.Comparator;

/**
 * PrintDescending class represents concrete command that prints the elements of a collection in descending order
 */
public class PrintDescending extends AbstractCommand {
    private final Collection collection;

    /**
     * Constructor
     */
    public PrintDescending(Collection collection) {
        this.collection = collection;
    }

    /**
     * Prints the elements of a collection in descending order
     */
    @Override
    public void execute() {
        collection.getPriorityQueue().stream().
                sorted(Comparator.comparing(ticket -> -ticket.hashCode())).
                forEachOrdered(t -> System.out.println(t.toString() + "HashCode: " + t.hashCode() + "\n"));
    }

    @Override
    public void undo() {

    }
}
