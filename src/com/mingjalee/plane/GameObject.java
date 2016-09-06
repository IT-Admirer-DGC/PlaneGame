package com.mingjalee.plane;

import java.awt.*;

/**
 * 游戏物体类
 * @author jerry
 * @create 16/9/6 11:49
 */
public class GameObject {
    Image img;
    double x;
    double y;
    double speed = 3;

    int width;
    int height;

    /**
     * 得到物体图片矩形
     */
    public Rectangle getRect() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public GameObject() {}

    public GameObject(Image img, double x, double y, double speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
}
