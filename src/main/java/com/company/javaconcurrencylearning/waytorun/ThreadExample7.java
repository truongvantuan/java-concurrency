package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample7 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            var currentThreadName = Thread.currentThread().getName();
            System.out.println(currentThreadName + " is running from ThreadExample6");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is stopped");
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        thread1.start();

    }
}
