package lab5.utils;

import lab5.storedClasses.*;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import java.time.LocalDateTime;

/**
 * Provides util methods to parse Ticket to xml and vise versa
 */
public class Parser {
    /**
     * Parse xml to ticket
     * @param attr Attributes of ticket
     * @return parsed ticket
     */
    public static Ticket xmlToTicket(NamedNodeMap attr) {
        Long ticketId = Long.valueOf(attr.getNamedItem("ticketId").getNodeValue());
        String ticketName = attr.getNamedItem("ticketName").getNodeValue();
        Long x = Long.valueOf(attr.getNamedItem("x").getNodeValue());
        Integer y = Integer.valueOf(attr.getNamedItem("y").getNodeValue());
        LocalDateTime creationDate = LocalDateTime.parse(attr.getNamedItem("creationDate").getNodeValue());
        long price = Long.parseLong(attr.getNamedItem("price").getNodeValue());
        long discount = Long.parseLong(attr.getNamedItem("discount").getNodeValue());
        boolean refundable = Boolean.parseBoolean(attr.getNamedItem("isRefundable").getNodeValue());
        TicketType ticketType = TicketType.valueOf(attr.getNamedItem("ticketType").getNodeValue());
        Integer eventId = Integer.valueOf(attr.getNamedItem("eventId").getNodeValue());
        String eventName = attr.getNamedItem("eventName").getNodeValue();
        String eventDescription = attr.getNamedItem("eventDescription").getNodeValue();
        EventType eventType;
        try {
            eventType = EventType.valueOf(attr.getNamedItem("eventType").getNodeValue());
        } catch (NullPointerException e) {
            eventType = null;
        }
        return new Ticket(
                ticketId,
                ticketName,
                new Coordinates(x, y),
                creationDate,
                price,
                discount,
                refundable,
                ticketType,
                new Event(eventId, eventName, eventDescription, eventType)
        );
    }

    /**
     * Parse Ticket to xml
     * @param ticketElement Element that will be added to the xml file
     * @param t Ticket that will be parsed
     * @return Element that will be added to the xml file
     */
    public static Element ticketToXml(Element ticketElement, Ticket t) {
        ticketElement.setAttribute("ticketId", t.getId().toString());
        ticketElement.setAttribute("ticketName", t.getName());
        ticketElement.setAttribute("x", t.getCoordinates().getX().toString());
        ticketElement.setAttribute("y", t.getCoordinates().getY().toString());
        ticketElement.setAttribute("creationDate", t.getCreationDate().toString());
        ticketElement.setAttribute("price", String.valueOf(t.getPrice()));
        ticketElement.setAttribute("discount", String.valueOf(t.getDiscount()));
        ticketElement.setAttribute("isRefundable", String.valueOf(t.isRefundable()));
        ticketElement.setAttribute("ticketType", t.getTicketType().toString());
        ticketElement.setAttribute("eventId", t.getEvent().getId().toString());
        ticketElement.setAttribute("eventName", t.getEvent().getName());
        ticketElement.setAttribute("eventDescription", t.getEvent().getDescription());
        try {
            ticketElement.setAttribute("eventType", t.getEvent().getEventType().toString());
        } catch(NullPointerException ignored) {

        }
        return ticketElement;
    }
}
