package com.company.javaconcurrencylearning.virtualthread;

import static com.company.javaconcurrencylearning.utils.ThreadUtils.printThreadName;
import static com.company.javaconcurrencylearning.utils.ThreadUtils.sleep;

public class VirtualThreadExample1 {

    public static void main(String[] args) {

        // Example1: start virtual thread
        Thread.ofVirtual().start(new RunnableForVirtualThread());

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Example2: unstart
        Thread virtualThread2 = Thread.ofVirtual().unstarted(new RunnableForVirtualThread());
        virtualThread2.start();
        try {
            virtualThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class RunnableForVirtualThread implements Runnable {
        @Override
        public void run() {
            printThreadName(true);
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running");
            }
            printThreadName(false);
        }
    }
}
