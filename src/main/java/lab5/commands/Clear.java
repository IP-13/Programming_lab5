package lab5.commands;

import lab5.utils.Collection;

/**
 * Clear class represents concrete command that clears the collection
 */
public class Clear extends AbstractCommand {
    private final Collection collection;

    /**
     * Constructor
     */
    public Clear(Collection collection) {
        this.collection = collection;
    }

    /**
     * Clears the collection
     */
    @Override
    public void execute() {
        collection.getPriorityQueue().clear();
    }

    @Override
    public void undo() {
        
    }
}
