package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample3 {

    public static void main(String[] args) {
        var myRunnable = new MyRunnable();
        myRunnable.run();
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable is running from ThreadExample3");
        }
    }
}
