package com.company.javaconcurrencylearning.threadproblem;

import com.company.javaconcurrencylearning.utils.ICounter;

public class CounterSynchronized implements ICounter {

    private long result;

    public void incTo(long countTo) {
        synchronized (this) {
            result = 0;
            for (long i = 0; i < countTo; i++) {
                result++;
            }
        }
    }


    public long get() {
        synchronized (this) {
            return result;
        }
    }
}