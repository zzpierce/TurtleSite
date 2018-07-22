package com.zz.back.util.image;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author pierce
 */
public class ImageUtil {

    /**
     * Flips the image horizontally
     */
    public BufferedImage flipHorizontally(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage to = new BufferedImage(width,
                height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = to.createGraphics();
        to = g2d.getDeviceConfiguration().createCompatibleImage(width,height, Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = to.createGraphics();
        Image from = bufferedImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);

        g2d.drawImage(from, 20, 0, -width, height, null);
        g2d.dispose();
        return to;
    }

}
