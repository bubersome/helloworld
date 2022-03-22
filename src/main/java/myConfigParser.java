


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class myConfigParser {
    public static void main(String[] args) {
        Path configPath = Paths.get(System.getProperty("user.home"), ".config", "DemoXMLParser");
        File configFile = new File(configPath.toString(), "myconfg.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = null;

        try{
            doc = builder.parse(configFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    doc.getDocumentElement().normalize();

    NodeList nodes = doc.getElementsByTagName("window");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node mynode = nodes.item(i);
            System.out.println(" Property =" + mynode.getNodeName());

        if (mynode.getNodeType() == Node.ELEMENT_NODE){
            Element myelement = (Element) mynode;

            System.out.printf("Theme = "+ myelement.getElementsByTagName("theme").item(0).getTextContent());
            System.out.printf("Fullscreen = "+ myelement.getElementsByTagName("fullscreen").item(0).getTextContent());
            System.out.printf("Icon set = " + myelement.getElementsByTagName("icons").item(0).getTextContent());
        }
        }
    }
}
