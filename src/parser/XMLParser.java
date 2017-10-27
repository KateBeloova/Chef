package parser;

import components.Vegetable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class XMLParser {
    private static final String PATH = "D://Vegetable.xml";

    public static void main(String[] args) {
        ArrayList<Vegetable> vegList = getVegFromXML();
        System.out.println("Vegetables from xml: ");
        for (Vegetable veg : vegList)
            System.out.println(veg.getName() + " " + veg.getCalories() + " " + veg.getFat() + " " + veg.getProteins()+  " " + veg.getWeight());
    }

    private static ArrayList<Vegetable> getVegFromXML() {
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        try {
          //  URL resource = XMLParser.class.getClassLoader().getResource("Vegetable.xml");
          //  File xmlFile = new File(resource.toURI());
            File xmlFile = new File(PATH);
            if (xmlFile.isFile() && xmlFile.canRead()) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);

                NodeList nList = doc.getElementsByTagName("Vegetable");
                System.out.println("Count of vegetables in file: " + (nList.getLength()));
               // System.out.println(nList.getLength());
                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        String name = eElement.getAttribute("Name");
                        double calories = Double.parseDouble(eElement.getElementsByTagName("Calories").item(0).getTextContent());
                        double fat = Double.parseDouble(eElement.getElementsByTagName("Fat").item(0).getTextContent());
                        double carbs = Double.parseDouble(eElement.getElementsByTagName("Carbs").item(0).getTextContent());
                        double weight = Double.parseDouble(eElement.getElementsByTagName("Weight").item(0).getTextContent());
                        vegetables.add(new Vegetable(name,calories, fat, carbs, weight));
                    }
                }
            } else {
                System.out.println("File doesn't exist.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred when parsing file. ");
        }

        return vegetables;
    }
}
