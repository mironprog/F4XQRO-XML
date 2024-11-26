import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public class hallgatoF4XQRO {
    public static void main(String[] args) throws Exception {

        File stylesheet = new File("F4XQRO_1126\\hallgatoF4XQRO.xsl");
        File xmlfile  = new File("F4XQRO_1126\\hallgatoF4XQRO.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlfile);

        StreamSource stylesource = new StreamSource(stylesheet);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(stylesource);

        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult("hallgatoF4XQRO.html");
        transformer.transform(source,result);
    }
}
