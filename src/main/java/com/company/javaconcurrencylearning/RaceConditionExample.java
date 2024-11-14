package com.company.javaconcurrencylearning;

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

    private record CountRunnable(ICounter counter, String message) implements Runnable {

        @Override
        public void run() {
            counter.incAndGet(1_000_000);
            System.out.println(message + counter.get());
        }
    }

    private static class Counter implements ICounter {

        private long result;

        public long incAndGet(long countTo) {
            result = 0;
            for (long i = 0; i < countTo; i++) {
                result++;
            }
            return result;
        }

        public long get() {
            return result;
        }
    }

    private static class CounterSynchronized implements ICounter {

        private long result;

        public long incAndGet(long countTo) {
            synchronized (this) {
                result = 0;
                for (long i = 0; i < countTo; i++) {
                    result++;
                }
                return result;
            }
        }


        public long get() {
            synchronized (this) {
                return result;
            }
        }
    }

}
