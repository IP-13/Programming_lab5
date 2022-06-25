package lab5.utils;

import lab5.storedClasses.Ticket;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;


/**
 * Contains collection
 */
public class Collection {
    private final String InitializationDate;
    private final String path;
    private final PriorityQueue<Ticket> priorityQueue = new PriorityQueue<>(Comparator.comparing(Ticket::getCreationDate));

    /**
     * Constructor
     * @param path Path to the file where initial data come from and where subsequently the data are stored
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public Collection(String path) throws ParserConfigurationException, IOException, SAXException {
        InitializationDate = new Date().toString();
        this.path = path;
        initialize();
    }

    public String getInitializationDate() {
        return InitializationDate;
    }

    public String getPath() {
        return path;
    }

    public PriorityQueue<Ticket> getPriorityQueue() {
        return priorityQueue;
    }

    private void initialize() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(this.path));
        NodeList ticketsNodeList = document.getDocumentElement().getElementsByTagName("ticket");
        for (int i = 0; i < ticketsNodeList.getLength(); i++) {
            Ticket ticket = Parser.xmlToTicket(ticketsNodeList.item(i).getAttributes());
            GenerateId.addTicketId(ticket.getId());
            GenerateId.addEventId(ticket.getEvent().getId());
            priorityQueue.add(ticket);
        }
    }
}
