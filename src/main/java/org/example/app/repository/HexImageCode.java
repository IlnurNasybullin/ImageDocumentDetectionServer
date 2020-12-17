package org.example.app.repository;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HexImageCode {

    public static String code(BufferedImage image) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", b);
        return DatatypeConverter.printHexBinary(b.toByteArray());
    }
}
