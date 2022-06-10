package org.malinowsky.appcodewars.pagination.helper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ElementsHandler extends DefaultHandler2 {

    public static final String ELEMENTS = "elements";
    public static final String SIZE = "size";
    public static final String PAGE_SIZE = "pageSize";
    public static final String ELEMENT = "element";

    private Elements elements;

    @Override
    public void startDocument() throws SAXException {
        elements = new Elements();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ELEMENTS:
                for(int i = 0; i < attributes.getLength(); i++) {
                    switch (attributes.getQName(i)){
                        case SIZE:
                            elements.setSize(Integer.parseInt(attributes.getValue(i)));
                            break;
                        case PAGE_SIZE:
                            elements.setPageSize(Integer.parseInt(attributes.getValue(i)));
                            break;
                    }
                };
                break;

            case ELEMENT:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elements.getElements().add(new String(Arrays.copyOfRange(ch, start, start + length)));
    }

    public Elements getElements() {
        return elements;
    }
}

