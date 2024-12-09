import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;

public class xPathModifyF4XQRO {
    public static void main(String[] args) {
        try {
            File inputFile = new File("F4XQRO_1119/xpathf4xqro1119/orarendF4XQRO.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            // Modify 1: "szak" nevének megváltoztatása 
            Node szakNode = (Node) xPath.compile("/orarend/ora[1]/szak").evaluate(doc, XPathConstants.NODE);
            if (szakNode != null) {
                szakNode.setTextContent("Mesterséges Intelligencia és Alkalmazása");
            }

            // Modify 2: "targy" attribútomhoz monogram hozzáadás
            NodeList targyNodes = (NodeList) xPath.compile("/orarend/ora/targy").evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < targyNodes.getLength(); i++) {
                Node targyNode = targyNodes.item(i);
                targyNode.setTextContent(targyNode.getTextContent() + " (BL)");
            }

            // Modify 3: "helyszin" megváltoztatása a id=3-nál 
            Node helyszinNode = (Node) xPath.compile("/orarend/ora[@id='3']/helyszin").evaluate(doc, XPathConstants.NODE);
            if (helyszinNode != null) {
                helyszinNode.setTextContent("XXXVII");
            }

            // A megváltoztatott fájl mentése egy új XML fájlba
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("orarendF4XQRO1.xml"));
            transformer.transform(source, result);

            System.out.println("Módosított XML fájl mentve: orarendF4XQRO1.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
