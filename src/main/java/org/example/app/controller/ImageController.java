package org.example.app.controller;

import org.example.app.entity.Document;
import org.example.app.repository.ImageDocumentDetector;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/converter")
public class ImageController {

    @PostMapping
    public Document getDocument(@RequestParam("file") MultipartFile file) throws IOException {
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
        return ImageDocumentDetector.detect(img);
    }
}
