package com.mingjalee.plane;

import com.mingjalee.util.GameUtil;
import com.mingjalee.util.MyFrame;

import java.awt.*;

/**
 * 游戏主窗口
 * @author jerry
 * @create 16/9/6 00:43
 */
public class PlaneGameFrame extends MyFrame {
    //背景图片加载,画图,main方法

    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane("images/plane.png", 50, 50);

    /**
     * 绘制画面
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        plane.draw(g);
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}
