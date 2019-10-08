import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();

        parser.parse(new File("resource/badEmp.xml"), handler);

        ArrayList<Employee> employees = handler.getEmployees();

        for (Employee employee : employees) {
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s",
                    employee.getName(), employee.getJob()));
        }
    }
}
