package com.mingjalee.plane;

import com.mingjalee.util.Constant;
import com.mingjalee.util.GameUtil;
import com.mingjalee.util.MyFrame;
import com.sun.glass.ui.Size;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 游戏主窗口
 * @author jerry
 * @create 16/9/6 00:43
 */
public class PlaneGameFrame extends MyFrame {
    //背景图片加载,画图,main方法

    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane("images/plane.png", 50, 50);

    ArrayList bulletList = new ArrayList();

    Date startTime;
    Date endTime;

    Explode bao;
    /**
     * 绘制画面
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        plane.draw(g);

        for (int i = 0; i < bulletList.size(); i++) {
            Bullet b = (Bullet)bulletList.get(i);
            b.draw(g);
            boolean crash = b.getRect().intersects(plane.getRect());
            if (crash) {
                //System.out.println("##########发生碰撞########");
                plane.setLive(false); //飞机挂掉
                if (bao == null) {
                    bao = new Explode(plane.x, plane.y);
                    endTime = new Date();
                }
                bao.draw(g);
            }
        }


        showStopwatch(g, new Date());

        //游戏结束 显示信息
        if (!plane.isLive()) {
            //游戏成绩等级显示
            printGrade(g);
        }
    }

    public void showStopwatch(Graphics g, Date currentTime) {
        int period = 0;
        try {
            if(currentTime == null){
                currentTime = new Date();
            }
            period = (int) ((currentTime.getTime() - startTime.getTime()) / 1000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //手动通知JVM销毁cur对象
        currentTime = null;
        System.gc();

        printInfo(g, "计时:" + period + "秒", 400 , 50, Color.white, 20);
    }

    /**
     * 等级显示
     * @param g
     */
    public void printGrade(Graphics g) {
        int period = (int) ( (endTime.getTime() - startTime.getTime()) / 1000 );
        printInfo(g, "时间:" + period + "秒", 100, 260, Color.white, 20 );

        switch (period / 10) {
            case 0:
                printInfo(g, "菜鸡", 100, 200, Color.white, 50);
                break;
            case 1:
                printInfo(g, "小鸡", 100, 200, Color.white, 50);
                break;
            case 2:
                printInfo(g, "老司机", 100, 200, Color.yellow, 50);
                break;
            default:
                printInfo(g, "鸡王", 100, 200, Color.yellow, 50);
                break;
        }
    }

    /**
     * 屏幕上打印信息
     * @param g
     * @param str
     */
    public void printInfo(Graphics g, String str, int x, int y, Color color, int size) {
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体",Font.BOLD,size);
        g.setFont(f);
        g.drawString(str, x , y);
        g.setColor(c);
    }

    @Override
    public void launchFrame() {
        super.launchFrame();

        //注册键盘监听
        addKeyListener(new KeyMonitor());

        for (int i = 0; i < 15; i++) {
            Bullet b = new Bullet();
            bulletList.add(b);
        }

        startTime = new Date();
    }

    /**
     * 键盘监听类,内部类可以方便访问外部类的属性
     * @author jerry
     */
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("按下键盘: " + e.getKeyChar() + " " + e.getKeyCode());
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("松开键盘: " + e.getKeyChar() + " " + e.getKeyCode());
            plane.minusDirection(e);
        }
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}
