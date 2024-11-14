package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample6 {

    public static void main(String[] args) {

        var mainThreadName = Thread.currentThread().getName();
        System.out.println(mainThreadName);

        Runnable runnable = () -> {
            var currentThreadName = Thread.currentThread().getName();
            System.out.println(currentThreadName + " is running from ThreadExample6");
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        thread1.start();

        Thread thread2 = new Thread(runnable, "Thread 2");
        thread2.start();

    }
}
