package com.company.javaconcurrencylearning.threadproblem;

import com.company.javaconcurrencylearning.utils.ICounter;

public class Counter implements ICounter {

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
