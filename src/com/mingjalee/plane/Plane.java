package com.mingjalee.plane;

import com.mingjalee.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 游戏飞机类
 * @author jerry
 * @create 16/9/6 00:53
 */
public class Plane extends GameObject {
    //属性:图片,坐标,移动速度; 方法:构造,绘制,移动。后期需要图片宽高,方向


    //飞机方向
    boolean left, right, up, down;

    public Plane(){

    }


    public Plane(String imgPath, double x, double y) {
        this(GameUtil.getImage(imgPath), x, y);
    }

    public Plane(Image img, double x, double y) {
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);

        this.x = x;
        this.y = y;

        this.speed = 6;
    }

    /**
     * 绘制飞机到画布
     */
    public void draw(Graphics g) {
        g.drawImage(img, (int)x, (int)y, null);

        move();
    }


    /**
     * 飞机移动位置
     */
    public void move() {
        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
        if (up) {
            y -= speed;
        }
        if (down) {
            y += speed;
        }
    }

    /**
     * 飞机飞行方向标记:键盘按下
     */
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            default:
                break;
        }
    }

    /**
     * 飞机飞行方向消除:键盘弹起
     */
    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            default:
                break;
        }
    }
}









