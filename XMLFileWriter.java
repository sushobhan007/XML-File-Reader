package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLFileWriter {
    public static void main(String[] args) throws Exception
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        Element element2 = document.createElement("GlobalIDs");
        document.appendChild(element2);

        Element element = document.createElement("Developers");
        element2.appendChild(element);
        Attr attr = document.createAttribute("Id");
        attr.setValue("1");
        element.setAttributeNode(attr);

        Element name = document.createElement("Name");
        name.appendChild(document.createTextNode("Sushobhan"));
        element.appendChild(name);

        Element surname = document.createElement("Surname");
        surname.appendChild(document.createTextNode("Mudi"));
        element.appendChild(surname);

        Element age = document.createElement("Age");
        age.appendChild(document.createTextNode("23"));
        element.appendChild(age);

        Element element3 = document.createElement("Deployment");
        element2.appendChild(element3);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult streamResult = new StreamResult
                (new File("C:\\Users\\Sushobhan\\IdeaProjects\\" +
                        "XMLFileHandlingJava\\src\\com\\company\\Output\\" +
                        "data.xml"));

        transformer.transform(source,streamResult);
    }
}
