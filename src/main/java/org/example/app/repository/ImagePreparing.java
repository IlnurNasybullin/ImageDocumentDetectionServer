package org.example.app.repository;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class ImagePreparing {

    private static final ImageLogger logger;

    static {
        logger = new ImageLogger();
    }

    public static BufferedImage prepare(BufferedImage image) {
        logger.setTitle("Image");
        logger.showImage(image);

        BufferedImage croppedImage = getCroppedImage(image);
        logger.setTitle("Cropped image");
        logger.showImage(croppedImage);

        BufferedImage grayImage = grayColor(croppedImage);
        logger.setTitle("Gray image");
        logger.showImage(grayImage);

        BufferedImage resizeImage = resize(grayImage, 640, 480);
        logger.setTitle("Resize image");
        logger.showImage(resizeImage);

        return resizeImage;
    }

    private static BufferedImage resize(BufferedImage image, int width, int height) {
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);

        BufferedImage resizeBufferedImage = new BufferedImage(resizedImage.getWidth(null), resizedImage.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D graphics = resizeBufferedImage.createGraphics();
        graphics.drawImage(resizedImage, 0, 0, null);
        graphics.dispose();

        return resizeBufferedImage;
    }

    private static BufferedImage grayColor(BufferedImage image) {
        BufferedImage grayImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(image, grayImg);

        return grayImg;
    }

    //Don't released image cropping
    private static BufferedImage getCroppedImage(BufferedImage image) {
        return image;
    }
}
