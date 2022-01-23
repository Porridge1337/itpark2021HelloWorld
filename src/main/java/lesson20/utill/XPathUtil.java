package lesson20.utill;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class XPathUtil {


    public static void aboveAverageSalary(Path path) throws IOException, ParserConfigurationException,
            SAXException, XPathExpressionException {
        try (InputStream inputStream = new FileInputStream(path.toString())) {
            Document xmlDocument = getXML(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            double avg = (double) xPath.compile("sum(//employees//employee//salary) div count(//employees//employee//salary)")
                    .evaluate(xmlDocument, XPathConstants.NUMBER);
            System.out.println("Среднее значение: " + avg);
            String expression = "//employees//employee";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = (Node) nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && avg < Double.valueOf(node.getChildNodes().item(9).getTextContent())) {
                    Element element = (Element) node;
                    System.out.println(element.getTextContent());
                }
            }
        }
    }

    private static Document getXML(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        return document;
    }
}
