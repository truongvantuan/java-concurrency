package com.company.javaconcurrencylearning.utils;

public class ThreadUtils {

    public static void printThreadName(boolean isStart) {
        var innerThreadName = Thread.currentThread().getName();
        System.out.printf(isStart ? "%s started%n" : "%s stopped%n", innerThreadName);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
