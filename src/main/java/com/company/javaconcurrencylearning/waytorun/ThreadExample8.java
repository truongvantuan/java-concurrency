package com.company.javaconcurrencylearning.waytorun;

public class ThreadExample8 {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void stopRequest() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable is running");
            while (!isStopRequested()) {
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppableRunnable stopped");
        }
    }

    public static void main(String[] args) {
        var stoppableRunnable = new StoppableRunnable();
        var thread = new Thread(stoppableRunnable, "StoppableRunnable Thread");
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        stoppableRunnable.stopRequest();
    }
}
