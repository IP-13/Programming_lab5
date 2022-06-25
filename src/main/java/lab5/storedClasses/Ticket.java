package lab5.storedClasses;

import lab5.utils.GenerateId;
import java.time.LocalDateTime;

/**
 * Represent object that will be stored in the collection
 */
public class Ticket implements Cloneable {
    private Long id = GenerateId.generateTicketId(); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate = LocalDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long price; //Значение поля должно быть больше 0
    private long discount; //Значение поля должно быть больше 0, Максимальное значение поля: 100
    private boolean refundable;
    private TicketType ticketType; //Поле не может быть null
    private Event event; //Поле не может быть null

    public Ticket(
            Long id,
            String name,
            Coordinates coordinates,
            LocalDateTime creationDate,
            long price,
            long discount,
            boolean refundable,
            TicketType ticketType,
            Event event
    ) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.discount = discount;
        this.refundable = refundable;
        this.ticketType = ticketType;
        this.event = event;
    }

    public Ticket(
            String name,
            Coordinates coordinates,
            long price,
            long discount,
            boolean refundable,
            TicketType ticketType,
            Event event
    ) {
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.discount = discount;
        this.refundable = refundable;
        this.ticketType = ticketType;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType type) {
        this.ticketType = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        return (int) (id +
                name.hashCode() +
                coordinates.getX() +
                coordinates.getY() +
                creationDate.hashCode() +
                price +
                discount +
                String.valueOf(refundable).hashCode() +
                ticketType.hashCode() +
                event.hashCode());
    }

    @Override
    public String toString() {
        return "Ticket Id: " + id + " " +
                "Ticket Name: " + name + " " +
                coordinates.toString() +
                "Creation date: " + creationDate + " " +
                "Price: " + price + " " +
                "Discount: " + discount + " " +
                "Refundable: " + refundable + " " +
                "Ticket Type: " + ticketType + " " +
                event.toString() + "\n";
    }

    @Override
    public Ticket clone() {
        return new Ticket(
                id,
                name,
                coordinates,
                creationDate,
                price,
                discount,
                refundable,
                ticketType,
                event
        );
    }
}
