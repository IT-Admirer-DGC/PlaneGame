package com.mingjalee.util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 窗口类
 * @author jerry
 * @create 16/9/6 00:30
 */
public class MyFrame extends Frame {
    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        setLocation(200, 100);
        setVisible(true);

        //画图线程
        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 画图线程类
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while(true) {
                repaint();
                try {
                    Thread.sleep(40); //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
