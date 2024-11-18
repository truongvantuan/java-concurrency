package com.company.javaconcurrencylearning.threadproblem;

import com.company.javaconcurrencylearning.utils.ICounter;

import static com.company.javaconcurrencylearning.utils.ThreadUtils.sleep;

public class RaceConditionExample2 {

    // 1. using Counter without Synchronized
    // 2. separate thread one for update, one for read

    private static Runnable getIncAndGetRunnable(ICounter counter) {
        return () -> counter.incTo(1_000_000);
    }

    private static Runnable getReadRunnable(ICounter counter) {
        return () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.printf("Reading value from Thread1: %d%n", counter.get());
            }

        };
    }

    public static void main(String[] args) {
        ICounter counter = new Counter();
        Thread thread1 = new Thread(getIncAndGetRunnable(counter));
        Thread thread2 = new Thread(getReadRunnable(counter));
        thread1.start();
        thread2.start();
    }
}
