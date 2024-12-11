import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DOMReadF4XQRO {
    public static void main(String[] args) {
        try {
            // XML fájl betöltése
            File inputFile = new File("XMLF4XQRO.XML");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Gyökérelem
            doc.getDocumentElement().normalize();
            System.out.println("Gyökérelem: " + doc.getDocumentElement().getNodeName());

            // Kaptárak kiíratása
            System.out.println("\nKaptárak:");
            NodeList kaptarList = doc.getElementsByTagName("kaptar");
            for (int i = 0; i < kaptarList.getLength(); i++) {
                Node kaptarNode = kaptarList.item(i);
                if (kaptarNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element kaptarElement = (Element) kaptarNode;
                    System.out.println("  Kaptár kód: " + kaptarElement.getAttribute("kapkod"));
                    System.out.println("    Hőmérséklet: " + kaptarElement.getElementsByTagName("homerseklet").item(0).getTextContent());
                    System.out.println("    Lokáció:");
                    Element lokacio = (Element) kaptarElement.getElementsByTagName("lokacio").item(0);
                    System.out.println("      Város: " + lokacio.getElementsByTagName("varos").item(0).getTextContent());
                    System.out.println("      Utca: " + lokacio.getElementsByTagName("utca").item(0).getTextContent());
                    System.out.println("      Házszám: " + lokacio.getElementsByTagName("hazszam").item(0).getTextContent());
                    NodeList keretszamList = kaptarElement.getElementsByTagName("keretszam");
                    System.out.print("    Keretszám(ok): ");
                    for (int j = 0; j < keretszamList.getLength(); j++) {
                        System.out.print(keretszamList.item(j).getTextContent() + " ");
                    }
                    System.out.println();
                }
            }

            // Királynők kiíratása
            System.out.println("\nKirálynők:");
            NodeList kiralynoList = doc.getElementsByTagName("kiralyno");
            for (int i = 0; i < kiralynoList.getLength(); i++) {
                Node kiralynoNode = kiralynoList.item(i);
                if (kiralynoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element kiralynoElement = (Element) kiralynoNode;
                    System.out.println("  Királynő kód: " + kiralynoElement.getAttribute("Kkod"));
                    System.out.println("    Név: " + kiralynoElement.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("    Életkor: " + kiralynoElement.getElementsByTagName("eletkor").item(0).getTextContent());
                    Element peterakasdatum = (Element) kiralynoElement.getElementsByTagName("peterakasdatum").item(0);
                    System.out.println("    Petérekás dátuma: " + peterakasdatum.getElementsByTagName("honap").item(0).getTextContent() + " " + peterakasdatum.getElementsByTagName("nap").item(0).getTextContent());
                }
            }

            // Dolgozók kiíratása
            System.out.println("\nDolgozók:");
            NodeList dolgozoList = doc.getElementsByTagName("dolgozo");
            for (int i = 0; i < dolgozoList.getLength(); i++) {
                Node dolgozoNode = dolgozoList.item(i);
                if (dolgozoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element dolgozoElement = (Element) dolgozoNode;
                    System.out.println("  Dolgozó kód: " + dolgozoElement.getAttribute("Dkod"));
                    System.out.println("    Név: " + dolgozoElement.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("    Kedvenc virág: " + dolgozoElement.getElementsByTagName("kedvenccirag").item(0).getTextContent());
                    Element meret = (Element) dolgozoElement.getElementsByTagName("meret").item(0);
                    System.out.println("    Méret:");
                    System.out.println("      Testhossz: " + meret.getElementsByTagName("testhossz").item(0).getTextContent());
                    System.out.println("      Súly: " + meret.getElementsByTagName("suly").item(0).getTextContent());
                }
            }

            // Herék kiíratása
            System.out.println("\nHerék:");
            NodeList hereList = doc.getElementsByTagName("here");
            for (int i = 0; i < hereList.getLength(); i++) {
                Node hereNode = hereList.item(i);
                if (hereNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element hereElement = (Element) hereNode;
                    System.out.println("  Here kód: " + hereElement.getAttribute("Hkod"));
                    System.out.println("    Név: " + hereElement.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("    Életkor: " + hereElement.getElementsByTagName("eletkor").item(0).getTextContent());
                    System.out.println("    Szárnysebesség: " + hereElement.getElementsByTagName("szarnysebesseg").item(0).getTextContent());
                }
            }

            // Mézkészítés kiíratása
            System.out.println("\nMézkészítés:");
            NodeList mezkeszitesList = doc.getElementsByTagName("mezkeszites");
            for (int i = 0; i < mezkeszitesList.getLength(); i++) {
                Node mezkeszitesNode = mezkeszitesList.item(i);
                if (mezkeszitesNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element mezkeszitesElement = (Element) mezkeszitesNode;
                    System.out.println("  Kaptár kód: " + mezkeszitesElement.getAttribute("kapkod"));
                    System.out.println("  Dolgozó kód: " + mezkeszitesElement.getAttribute("Dkod"));
                    System.out.println("    Virág: " + mezkeszitesElement.getElementsByTagName("virag").item(0).getTextContent());
                    System.out.println("    Mennyiség: " + mezkeszitesElement.getElementsByTagName("Mennyiség").item(0).getTextContent());
                }
            }

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }
    }
}
