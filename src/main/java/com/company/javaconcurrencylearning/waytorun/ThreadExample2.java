package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample2 {

    public static void main(String[] args) {

        Thread thread = new MyThread();
        thread.start();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread is running from ThreadExample2");
        }
    }
}
