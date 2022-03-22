package myConfigParser;



import java.io.File;

import java.io.IOException;

import java.nio.file.Path;

import java.nio.file.Paths;



import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;



import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NamedNodeMap;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;



public class ConfigParser {



    public static void main(String[] args) {

        Path configPath = Paths.get(System.getProperty("user.home"), ".config", "DemoXMLParser");

        File configFile = new File(configPath.toString(), "myconfig.xml");

        DocumentBuilderFactory factory =

                DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;



        try {

            builder = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {

            e.printStackTrace();

        }



        Document doc = null;



        try {

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

            System.out.println("Property = " + mynode.getNodeName());



            if (mynode.getNodeType() == Node.ELEMENT_NODE) {

                Element myelement = (Element) mynode;



                System.out.println("Theme = " + myelement.getElementsByTagName("theme").item(0).getTextContent());

                System.out.println("Fullscreen = " + myelement.getElementsByTagName("fullscreen").item(0).getTextContent());

                System.out.println("Icon set = " + myelement.getElementsByTagName("icons").item(0).getTextContent());

            } // close if

        } // close for

    } // close method

} //close class
 