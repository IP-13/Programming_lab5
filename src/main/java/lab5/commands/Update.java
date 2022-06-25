package lab5.commands;

import lab5.storedClasses.Ticket;
import lab5.utils.Collection;
import lab5.utils.GenerateId;

/**
 * Update class represents concrete command that updates the value of the collection element whose id is equal to the given one
 */
public class Update extends AbstractCommand {
    private final Collection collection;
    private final Long ticketToUpdateId;
    private Ticket ticketThatUpdates;

    /**
     * Constructor
     * @param ticketToUpdateId ID ot the ticket to update
     * @param ticketThatUpdates Ticket by whose value ticket of the collection will be updated
     */
    public Update(Collection collection, Long ticketToUpdateId, Ticket ticketThatUpdates) {
        this.collection = collection;
        this.ticketToUpdateId = ticketToUpdateId;
        this.ticketThatUpdates = ticketThatUpdates;
    }

    /**
     * Updates the value of the collection element whose id is equal to the given one
     */
    @Override
    public void execute() {
        if (GenerateId.checkId(ticketToUpdateId)) {
            for (Ticket t : collection.getPriorityQueue()) {
                if (ticketToUpdateId.equals(t.getId())) {
                    Ticket temp = t.clone();
                    updateTicket(t, ticketThatUpdates);
                    ticketThatUpdates = temp;
                    break;
                }
            }
        }
    }

    /**
     * Returns updated ticket to its previous condition
     */
    @Override
    public void undo() {
        for (Ticket t : collection.getPriorityQueue()) {
            if (ticketToUpdateId.equals(t.getId())) {
                updateTicket(t, ticketThatUpdates);
                break;
            }
        }
    }

    private void updateTicket(Ticket t, Ticket updating) {
        t.setName(updating.getName());
        t.setCoordinates(updating.getCoordinates());
        t.setPrice(updating.getPrice());
        t.setDiscount(updating.getDiscount());
        t.setRefundable(updating.isRefundable());
        t.setTicketType(updating.getTicketType());
        t.setEvent(updating.getEvent());
    }
}
