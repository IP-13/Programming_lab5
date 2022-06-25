import lab5.utils.Collection;
import lab5.utils.DataScanner;
import lab5.utils.UserDataScanner;
import lab5.utils.UserConsole;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        DataScanner dataScanner = new UserDataScanner(new Scanner(System.in));
        Collection collection = new Collection("C:\\Users\\Acer\\IdeaProjects\\lab_5.v2.0\\src\\main\\java\\data.xml");
        UserConsole userConsole = new UserConsole(collection, dataScanner);
        userConsole.run();
    }
}
