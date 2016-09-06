package com.mingjalee.plane;

import com.mingjalee.util.GameUtil;

import java.awt.*;

/**
 * 爆炸类
 * @author jerry
 * @create 16/9/6 18:50
 */
public class Explode {
    //属性:位置xy,图片组; 方法:画图,构造
    double x;
    double y;

    static final int imgCount = 16;
    static Image[] imgs = new Image[imgCount];
    static {
        for (int i = 0; i < imgCount; i++) {
            imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
            imgs[i].getWidth(null);
        }
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int count = 0;
    public void draw(Graphics g) {
        if(count < imgCount) {
            g.drawImage(imgs[count], (int)x, (int)y, null);
            count++;
        }
    }

}
