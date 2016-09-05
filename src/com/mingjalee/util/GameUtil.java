package com.mingjalee.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 图片加载类
 * @author jerry
 * @create 16/9/6 00:34
 */
public class GameUtil {
    private GameUtil(){}

    public static Image getImage(String imgPath) {
        BufferedImage img = null;
        URL url = GameUtil.class.getClassLoader().getResource(imgPath);
        try {
            img = javax.imageio.ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
