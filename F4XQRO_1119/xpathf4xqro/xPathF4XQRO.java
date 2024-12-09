import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;

public class xPathF4XQRO {
    public static void main(String[] args) {
        try {
            File inputFile = new File("F4XQRO_1119/xpathf4xqro/studentF4XQRO.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            // Az összes hallgató
            System.out.println("Minden hallgató neve:");
            NodeList nodeList = (NodeList) xPath.compile("/class/student/keresztnev").evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getTextContent());
            }

            // Hallgató 2-es ID-vel:
            System.out.println("\nHallgató id=2:");
            Node node = (Node) xPath.compile("/class/student[@id='2']").evaluate(doc, XPathConstants.NODE);
            if (node != null) {
                System.out.println("Vezetéknév: " + xPath.compile("vezeteknev").evaluate(node));
                System.out.println("Keresztnév: " + xPath.compile("keresztnev").evaluate(node));
                System.out.println("Becenév: " + xPath.compile("becenev").evaluate(node));
                System.out.println("Kor: " + xPath.compile("kor").evaluate(node));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}