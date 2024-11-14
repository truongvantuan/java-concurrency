package com.company.javaconcurrencylearning.threadproblem;

import com.company.javaconcurrencylearning.utils.ICounter;

public class RaceConditionExample {

    public static void main(String[] args) {

        ICounter counter = new Counter();
        ICounter counterSynchronized = new CounterSynchronized();

        Thread thread1 = new Thread(new CountRunnable(counterSynchronized, "Thread1 has result: "));
        Thread thread2 = new Thread(new CountRunnable(counterSynchronized, "Thread2 has result: "));
        thread1.start();
        thread2.start();

    }

    private record CountRunnable(ICounter iCounter, String message) implements Runnable {

        @Override
        public void run() {
            iCounter.incAndGet(1_000_000);
            System.out.println(message + iCounter.get());
        }
    }


}
