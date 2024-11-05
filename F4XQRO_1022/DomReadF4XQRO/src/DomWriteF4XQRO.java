import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys; 
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom. Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class DomWriteF4XQRO {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document doc = builder.newDocument();
    
        Element root = doc.createElementNS("DOMF4XQRO", "hallgatok"); 
        doc.appendChild(root);
    
        root.appendChild(createUser(doc, "1", "Peter", "Nagy", "Web Developer")); 
        root.appendChild(createUser(doc, "2", "Piroska", "Vigh", "Java programozo")); 
        root.appendChild(createUser(doc, "3", "Ferenc", "Kiss", "Associate professor"));
    }
}
