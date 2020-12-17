package org.example.app.repository;

import javax.swing.*;
import java.awt.*;

public class ImageLogger extends JFrame {

    private ImagePanel panel;

    public ImageLogger() {
        super("");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        panel = new ImagePanel();
        add(panel);
        setVisible(true);
    }

    public void showImage(Image image) {
        setSize(image.getWidth(this), image.getHeight(this));
        panel.setImage(image);
        panel.paint(getGraphics());
    }

    private static class ImagePanel extends JPanel {

        private Image image;

        public void setImage(Image image) {
            this.image = image;
            setSize(image.getWidth(this), image.getHeight(this));
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, this);
        }
    }
}
