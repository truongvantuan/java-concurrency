package com.company.javaconcurrencylearning.threadproblem;

import com.company.javaconcurrencylearning.utils.ICounter;

public class Counter implements ICounter {

    private long result;

    public void incTo(long countTo) {
        result = 0;
        for (long i = 0; i < countTo; i++) {
            result++;
        }
    }

    public long get() {
        return result;
    }
}
