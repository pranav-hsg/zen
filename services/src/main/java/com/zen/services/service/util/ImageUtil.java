package com.zen.services.service.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {

    private ImageUtil() {
        // Static class, don't instantiate
    }

    public static byte[] scale(InputStream in, int height, int width) throws IOException {
        BufferedImage img = ImageIO.read(in);
        if(height == 0) {
            height = (width * img.getHeight())/ img.getWidth();
        }
        if(width == 0) {
            width = (height * img.getWidth())/ img.getHeight();
        }
        Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0,0,0), null);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(imageBuff, "jpg", buffer);
        return buffer.toByteArray();
    }

    public static byte[] resizeAndScale(InputStream in, int width, int height) throws IOException {
        BufferedImage img = ImageIO.read(in);
        int heightWithRequiredWidth = (width * img.getHeight())/ img.getWidth();
        int widthWithRequiredHeight = (height * img.getWidth())/ img.getHeight();
        Image scaledImage = null;
        if(heightWithRequiredWidth > height) {
            scaledImage = img.getScaledInstance(width, heightWithRequiredWidth, Image.SCALE_SMOOTH);
        } else {
            scaledImage = img.getScaledInstance(widthWithRequiredHeight, height, Image.SCALE_SMOOTH);
        }
        BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        imageBuff = imageBuff.getSubimage(0, 0, width, height);
        imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0,0,0), null);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(imageBuff, "jpg", buffer);
        return buffer.toByteArray();
    }

}
