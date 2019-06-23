package com.ombrodrigo.converter.bean.converters;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Service
public class XmlConverter implements IConverter {
    public String convert(InputStream stream) {
        try {
            Document document = createDocument(stream);

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            return "XML";
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // ajustar isso
            return "Error reading XML";
        }
    }

    private Document createDocument(InputStream stream)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(stream);
        document.getDocumentElement().normalize();

        return document;
    }
}