package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample4 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable is running from ThreadExample4");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
