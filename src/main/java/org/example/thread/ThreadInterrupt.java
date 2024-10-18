package org.example.thread;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/16 9:28
 **/
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new CountThread();
        thread.start();

        Thread.sleep(5000L);

        thread.interrupt();

        thread.join();

        Thread.sleep(3000L);

        VolatileInterruptThread volatileInterruptThread = new VolatileInterruptThread();
        volatileInterruptThread.start();

        Thread.sleep(3000L);
        volatileInterruptThread.running = false;

        System.out.println("main Thread end");
    }

    static class CountThread extends Thread {
        @Override
        public void run() {
            int i=0;
            while(!isInterrupted()) {

//                try {
//                    sleep(1000L);  一个线程在 sleep 状态下被中断，sleep 调用将会被提前终止，并抛出 InterruptedException
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println("count:"+i++);
            }

            System.out.println("CountThread end");
        }
    }

    static class VolatileInterruptThread extends Thread {
        public volatile boolean running = true;

        @Override
        public void run() {
            while(running){
                System.out.println("VolatileInterruptThread is running");
            }
            System.out.println("VolatileInterruptThread end");
        }
    }
}
