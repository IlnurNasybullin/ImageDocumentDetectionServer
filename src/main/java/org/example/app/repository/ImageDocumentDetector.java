package org.example.app.repository;

import org.example.app.entity.Document;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageDocumentDetector {

    public static final String DOCUMENT = "document";

    public static Document detect(BufferedImage img) throws IOException {
        BufferedImage preparedImage = ImagePreparing.prepare(img);
        Document document = new Document();
        document.setClassification(classify(preparedImage));
        document.setContent(HexImageCode.code(preparedImage));

        return document;
    }

    //classify isn't released
    private static String classify(BufferedImage preparedImage) {
        return DOCUMENT;
    }
}
