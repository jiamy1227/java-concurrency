package org.example.thread;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/15 17:16
 **/
public class NewThread {
    public static void main(String[] args) {
        Thread t1 = new HelloThread();
        t1.start();

        Thread t2 = new Thread(new RunnableThread());
        t2.start();

        Thread t3 = new Thread(() ->
                System.out.println("functional thread")
        );
        t3.start();

        Thread t4 = new HelloThread2();
        t4.start();

        try {
            t4.join(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("main thread end...");

    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("new thread extends Thread");
        }
    }

    static class RunnableThread implements Runnable {
        @Override
        public void run() {
            System.out.println("new Thread implements Runnable");
        }
    }

    static class HelloThread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("new thread extends Thread");
        }
    }
}
