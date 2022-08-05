package com.example;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class TikaOOMExample {

    public static void main(String... args) throws IOException, TikaException, SAXException {
        final Parser parser = new PDFParser();

        final ContentHandler contentHandler = new BodyContentHandler(-1);
        final Metadata metadata = new Metadata();
        final ParseContext context = new ParseContext();

        try (InputStream inputStream = TikaInputStream.get(
                TikaOOMExample.class.getClassLoader().getResourceAsStream("7581cfbf-8c1e-4154-bfbb-4e633d858d5f.pdf"))) {
            System.out.println("Started parsing the file!");

            parser.parse(inputStream, contentHandler, metadata, context);
        }

        System.out.println("Parsing was successful!");
    }
}
