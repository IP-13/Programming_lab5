package lab5.commands;

import lab5.utils.Collection;
import lab5.utils.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Save class represents concrete command that saves the collection to a file
 */
public class Save extends AbstractCommand {
    private final Collection collection;

    /**
     * Constructor
     */
    public Save(Collection collection) {
        this.collection = collection;
    }

    /**
     * Saves the collection to a file
     */
    @Override
    public void execute() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("tickets");
            collection.getPriorityQueue().
                    forEach(t -> rootElement.appendChild(Parser.ticketToXml(doc.createElement("ticket"), t)));
            doc.appendChild(rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file = new StreamResult(new File(collection.getPath()));
            transformer.transform(source, file);
        } catch (ParserConfigurationException e) {
            System.out.println("Error");
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void undo() {

    }
}
