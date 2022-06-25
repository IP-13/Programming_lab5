package lab5.utils;

import lab5.exceptions.ExecuteScriptException;
import lab5.storedClasses.*;
import java.util.Scanner;

/**
 * Reads command from the script
 */
public class ScriptScanner implements DataScanner {
    private final Scanner scanner;
    private boolean open;

    /**
     * Constructor
     * @param scanner Scanner which will read commands from the script
     */
    public ScriptScanner(Scanner scanner) {
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
        try {
            return scanner.nextLong();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public String readTicketName() {
        return scanner.next();
    }

    @Override
    public Coordinates readCoordinates() {
        return new Coordinates(readX(), readY());
    }

    @Override
    public Long readX() {
        try {
            return scanner.nextLong();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public Integer readY() {
        try {
            return scanner.nextInt();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public long readPrice() {
        try {
            return scanner.nextLong();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public long readDiscount() {
        try {
            return scanner.nextLong();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public boolean readRefundable() {
        try {
            return scanner.nextBoolean();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public TicketType readTicketType() {
        try {
            return TicketType.valueOf(scanner.next());
        } catch (Throwable e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public Event readEvent() {
        return new Event(readEventName(), readEventDescription(), readEventType());
    }

    @Override
    public Integer readEventId() {
        try {
            return scanner.nextInt();
        } catch (ExecuteScriptException e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public String readEventName() {
        return scanner.next();
    }

    @Override
    public String readEventDescription() {
        return scanner.next();
    }

    @Override
    public EventType readEventType() {
        try {
            return EventType.valueOf(scanner.next());
        } catch (Throwable e) {
            throw new ExecuteScriptException("Invalid data in script");
        }
    }

    @Override
    public String readPath() {
        return scanner.next();
    }

    @Override
    public String readCommand() {
        return scanner.next();
    }
}
