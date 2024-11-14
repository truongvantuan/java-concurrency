package com.company.javaconcurrencylearning.waytorun;

import static com.company.javaconcurrencylearning.utils.ThreadUtils.printThreadName;
import static com.company.javaconcurrencylearning.utils.ThreadUtils.sleep;

public class ThreadExample10 {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                printThreadName(true);
                for (int i = 0; i < 10; i++) {
                    sleep(1000);
                    System.out.println("Running");
                }
                printThreadName(false);
            }
        };

        var thread = new Thread(runnable);
        thread.setDaemon(true);
        printThreadName(true);
        thread.start();
        sleep(1000);
        printThreadName(false);

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
