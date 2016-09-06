package com.mingjalee.plane;

import com.mingjalee.util.GameUtil;
import com.mingjalee.util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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


    @Override
    public void launchFrame() {
        super.launchFrame();

        //注册键盘监听
        addKeyListener(new KeyMonitor());
    }

    /**
     * 键盘监听类,内部类可以方便访问外部类的属性
     * @author jerry
     */
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下键盘: " + e.getKeyChar() + " " + e.getKeyCode());

            plane.move(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("松开键盘: " + e.getKeyChar() + " " + e.getKeyCode());
        }
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}
