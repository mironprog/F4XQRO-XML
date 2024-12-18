import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class DomReadF4XQRO {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        
        
        File xmlFile = new File("F4XQRO_1022/DomReadF4XQRO/src/hallgato.xml");

        DocumentBuilderFactory factorx = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factorx.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        
        NodeList nlist = doc.getElementsByTagName("hallgato");

        for (int i = 0; i < nlist.getLength(); i++) {
            Node nNode = nlist.item(i);

            System.out.println("\nCurrent Element: " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE){

                Element elem = (Element) nNode;

                String uid = elem.getAttribute("id");

                Node node1 = elem.getElementsByTagName("keresztnev").item(0);
                String fname = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("vezeteknev").item(0);
                String lname = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("foglalkozas").item(0);
                String pname = node3.getTextContent();

                System.out.println("User id: " + uid);
                System.out.println("First name: " +fname);
                System.out.println("Last name: " + lname);
                System.out.println("Profession: "+ pname);

                
            }
            
        }


    }
    
}