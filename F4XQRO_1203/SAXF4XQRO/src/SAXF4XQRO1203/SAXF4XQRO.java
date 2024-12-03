package SAXF4XQRO1203;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXF4XQRO {

    public static void main(String[] args) {
        try {
            // SAXParserFactory példányosítása
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Saját handler
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("\nStart: " + qName);
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.println("Tartalom: " + attributes.getQName(i) + " = {" + attributes.getValue(i) + "}");
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End: " + qName + "\n");
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length).trim();
                    if (!content.isEmpty()) {
                        System.out.println("\nSzöveg: " + content);
                    }
                }
            };

            // XML fájl feldolgozása
            saxParser.parse("F4XQRO_1203\\F4XQRO_kurzusfelvetel.xml", handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
        }
    }
}
