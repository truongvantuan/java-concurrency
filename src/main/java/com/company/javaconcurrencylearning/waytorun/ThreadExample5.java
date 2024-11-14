package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample5 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.printf("Thread name is %s%n", Thread.currentThread().getName());
            System.out.println("Runnable is running from ThreadExample5");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
