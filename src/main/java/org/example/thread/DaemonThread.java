package org.example.thread;

import java.util.HashMap;

import static java.lang.Thread.sleep;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/18 14:48
 **/
public class DaemonThread {

    public static void main(String[] args) {

//        Thread thread = new GenericThread();
//        thread.start();

        Thread thread2 = new GenericThread();
        thread2.setDaemon(true); // 线程设置为守护线程，非守护线程都结束后，jvm会结束；
        thread2.start();

        try {
            sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main thread end");


    }

    static class GenericThread extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("watching....");
            }
        }
    }
}
