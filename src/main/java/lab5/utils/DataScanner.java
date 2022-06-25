package lab5.utils;

import lab5.storedClasses.*;
import java.util.Scanner;

/**
 * Interface for scanner that reads the commands
 */
public interface DataScanner {
    /**
     * Opens or closes the DataScanner
     * @param open Boolean value which signals if scanner is open or closed
     */
    public void setOpen(boolean open);

    /**
     * Check if scanner is opened
     * @return True if scanner is opened, false otherwise
     */
    public boolean isOpen();

    /**
     * Getter for scanner
     * @return Scanner field of DataScanner
     */
    public Scanner getScanner();

    /**
     * Reads ticket
     * @return Read ticket
     */
    public Ticket readTicket();

    /**
     * Reads ID
     * @return Read ID
     */
    public Long readTicketId();

    /**
     * Reads ticket name
     * @return Read ticket name
     */
    public String readTicketName();

    /**
     * Reads coordinates
     * @return Read coordinates
     */
    public Coordinates readCoordinates();

    /**
     * Reads x coordinate
     * @return Read x coordinate
     */
    public Long readX();

    /**
     * Reads y coordinate
     * @return Read y coordinate
     */
    public Integer readY();

    /**
     * Reads price
     * @return Read price
     */
    public long readPrice();

    /**
     * Reads discount
     * @return Read discount
     */
    public long readDiscount();

    /**
     * Reads refundable
     * @return Read refundable
     */
    public boolean readRefundable();

    /**
     * Reads ticket type
     * @return Read ticket type
     */
    public TicketType readTicketType();

    /**
     * Reads event
     * @return Read event
     */
    public Event readEvent();

    /**
     * Reads event ID
     * @return Read event ID
     */
    public Integer readEventId();

    /**
     * Reads event name
     * @return Read event name
     */
    public String readEventName();

    /**
     * Reads event description
     * @return Read event description
     */
    public String readEventDescription();

    /**
     * Reads event type
     * @return Read event type
     */
    public EventType readEventType();

    /**
     * Reads path
     * @return Read path
     */
    public String readPath();

    /**
     * Reads command
     * @return Read command
     */
    public String readCommand();
}
