package lab5.utils;

import lab5.storedClasses.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Reads commands from the User
 */
public class UserDataScanner implements DataScanner {
    private final Scanner scanner;
    private boolean open;

    /**
     * Constructor
     * @param scanner Scanner which will read commands from the User
     */
    public UserDataScanner(Scanner scanner) {
        this.scanner = scanner;
        open = true;
    }

    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public Ticket readTicket() {
        System.out.println("Enter ticket. Value type: Ticket.");
        return new Ticket(
                readTicketName(),
                readCoordinates(),
                readPrice(),
                readDiscount(),
                readRefundable(),
                readTicketType(),
                readEvent());
    }

    @Override
    public Long readTicketId() {
        System.out.println("Enter ticket id. Value type: Long. ");
        long ticketId;
        while (true) {
            while (!scanner.hasNextLong()) {
                scanner.next();
                System.err.println("Input Mismatch Exception. Value type: Long. Try again");
            }
            ticketId = scanner.nextLong();
            if (ticketId <= 0) {
                System.err.println("Ticket id must be greater than 0. Try again");
            } else {
                return ticketId;
            }
        }
    }

    @Override
    public String readTicketName() {
        System.out.println("Enter ticket name. Value type: String. ");
        return scanner.next();
    }

    @Override
    public Coordinates readCoordinates() {
        System.out.println("Enter coordinates. Value type: Coordinates. ");
        return new Coordinates(readX(), readY());
    }

    @Override
    public Long readX() {
        System.out.println("Enter x. Value type: Long. ");
        while (!scanner.hasNextLong()) {
            scanner.next();
            System.err.println("Input Mismatch Exception. Value type: Long. Try again");
        }
        return scanner.nextLong();
    }

    @Override
    public Integer readY() {
        System.out.println("Enter y. Value type: Integer. ");
        int y;
        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.err.println("Input Mismatch Exception. Value type: Integer. Try again");
            }
            y = scanner.nextInt();
            if (y <= -37) {
                System.err.println("Y must be greater than -37. Enter new value: ");
            } else {
                return y;
            }
        }
    }

    @Override
    public long readPrice() {
        System.out.println("Enter price. Value type: long. ");
        long price;
        while (true) {
            while (!scanner.hasNextLong()) {
                scanner.next();
                System.err.println("Input Mismatch Exception. Value type: long. Try again");
            }
            price = scanner.nextLong();
            if (price <= 0) {
                System.err.println("Price must be greater than 0. Enter new value: ");
            } else {
                return price;
            }
        }
    }

    @Override
    public long readDiscount() {
        System.out.println("Enter discount. Value type: long. ");
        long discount;
        while (true) {
            while (!scanner.hasNextLong()) {
                scanner.next();
                System.err.println("Input Mismatch Exception. Value type: long. Try again");
            }
            discount = scanner.nextLong();
            if (discount <= 0 || discount > 100) {
                System.err.println("Discount must be greater that 0 and smaller or equal than 100. Enter new value: ");
            } else {
                return discount;
            }
        }
    }

    @Override
    public boolean readRefundable() {
        System.out.println("Enter refundable. Value type: boolean. ");
        while (!scanner.hasNextBoolean()) {
            scanner.next();
            System.err.println("Input Mismatch Exception. Value type: boolean. Try again");
        }
        return scanner.nextBoolean();
    }

    @Override
    public TicketType readTicketType() {
        System.out.println("Enter ticket type. Value type: TicketType. ");
        System.out.println("List of available ticket types: ");
        System.out.println(Arrays.toString(TicketType.values()));
        String ticketType = scanner.next();
        while (!Arrays.toString(TicketType.values()).contains(ticketType)) {
            System.err.println("Input Mismatch Exception. Value type: TicketType. Try again");
            ticketType = scanner.next();
        }
        return TicketType.valueOf(ticketType);
    }

    @Override
    public Event readEvent() {
        System.out.println("Enter event. Value type: Event. ");
        return new Event(readEventName(), readEventDescription(), readEventType());
    }

    @Override
    public Integer readEventId() {
        System.out.println("Enter event id. Value type: Integer. ");
        int eventId;
        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.err.println("Input Mismatch Exception. Value type: Long. Try again");
            }
            eventId = scanner.nextInt();
            if (eventId <= 0) {
                System.err.println("Y must be greater than -37. Enter new value: ");
            } else {
                return eventId;
            }
        }
    }

    @Override
    public String readEventName() {
        System.out.println("Enter event name. Value type: String. ");
        return scanner.next();
    }

    @Override
    public String readEventDescription() {
        System.out.println("Enter event description. Value type: String. ");
        return scanner.next();
    }

    @Override
    public EventType readEventType() {
        System.out.println("Enter event type. Value type: EventType. ");
        System.out.println("List of available event types: ");
        System.out.println(Arrays.toString(EventType.values()));
        String eventType = scanner.next();
        while (!Arrays.toString(EventType.values()).contains(eventType)) {
            System.err.println("Input Mismatch Exception. Value type: EventType. Try again");
            eventType = scanner.next();
        }
        return EventType.valueOf(eventType);
    }

    @Override
    public String readPath() {
        System.out.println("Enter file path. Value type: String. ");
        return scanner.next();
    }

    @Override
    public String readCommand() {
        System.out.println("Enter new command: ");
        return scanner.next();
    }
}
