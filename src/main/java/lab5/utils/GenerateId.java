package lab5.utils;

import lab5.exceptions.IdException;
import java.util.ArrayList;

/**
 * Class that generates ID and stores all used IDs
 */
public class GenerateId {
    private static final ArrayList<Long> ticketIdList = new ArrayList<>();
    private static final ArrayList<Integer> eventIdList = new ArrayList<>();
    private static Long ticketId = 1L;
    private static Integer eventId = 1;

    /**
     * Static method that check if ID is free
     * @param id ID to check
     * @return False if ID is free, true otherwise
     */
    public static boolean checkId(Long id) {
        return ticketIdList.contains(id);
    }

    /**
     * Check if ticket ID is free and adds
     * @param id ticket ID to check
     */
    public static void addTicketId(Long id) {
        if (ticketIdList.contains(id)) {
            throw new IdException("Ticket ID should be unique!!!");
        }
        else {
            ticketIdList.add(id);
        }
    }

    /**
     * Check if event ID is free ad adds it
     * @param id event ID to check
     */
    public static void addEventId(Integer id) {
        if (eventIdList.contains(id)) {
            throw new IdException("Event ID should be unique!!!");
        }
        else {
            eventIdList.add(id);
        }
    }

    /**
     * Generates unique ticket ID
     * @return unique ticket ID
     */
    public static Long generateTicketId() {
        while (ticketIdList.contains(ticketId)) {
            ticketId++;
        }
        return ticketId++;
    }

    /**
     * Generates unique event ID
     * @return unique event ID
     */
    public static Integer generateEventId() {
        while (eventIdList.contains(eventId)) {
            eventId++;
        }
        return eventId++;
    }
}
