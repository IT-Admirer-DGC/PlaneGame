package com.mingjalee.plane;

import com.mingjalee.util.Constant;

import java.awt.*;

/**
 * 子弹类
 * @author jerry
 * @create 16/9/6 10:44
 */
public class Bullet {
    //属性:位置xy,速度,角度; 方法:随机角度,子弹移动,画板,构造 后期:宽高

    double x;
    double y;
    double speed;
    double degree;
    //子弹大小
    int width;
    int height;

    public Bullet() {
        degree = Math.random() * Math.PI * 2;
        speed = 3;

        width = 10;
        height = 10;

        x = Constant.GAME_WIDTH/2 - width/2;
        y = Constant.GAME_HEIGHT/2 - height/2;
    }

    //public Bullet(double x, double y) {
    //    this.x = x;
    //    this.y = y;
    //}

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x, (int)y, width, height);
        g.setColor(c);

        move();
    }

    /**
     * 子弹移动
     */
    public void move() {
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

    }


}
