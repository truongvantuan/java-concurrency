package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample9 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                sleep(1000);
                System.out.println("Running");
            }
        };

        var thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3100);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
