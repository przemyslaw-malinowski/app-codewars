package org.malinowsky.appcodewars.humming.numbers;

import lombok.Getter;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlHummingHandler extends DefaultHandler2 {
    @Getter
    private List<Integer> input;

    @Override
    public void startDocument() throws SAXException {
        input = new ArrayList<>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        Integer integer = Integer.valueOf(String.valueOf(Arrays.copyOfRange(ch, start, start + length)));
        input.add(integer);
    }

    @Override
    public void endDocument() throws SAXException {
        input.forEach(System.out::println);
    }
}
