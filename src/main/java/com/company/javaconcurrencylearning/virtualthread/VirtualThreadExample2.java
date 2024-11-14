package com.company.javaconcurrencylearning.virtualthread;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadExample2 {

    // 1. create 100_000 virtual thread
    // 2. each virtual thread do 10!

    public static void main(String[] args) {
        int threadCount = 100_000;
        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= threadCount; i++) {
            int currentIndex = i;
            var thread = Thread.ofVirtual().start(() -> {
                System.out.printf("Thread[%s]: %d\n", currentIndex, countOneToNumber(10));
            });
            threadList.add(thread);
        }

        threadList.forEach(VirtualThreadExample2::joinThread);
    }

    private static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static long countOneToNumber(long to) {
        long result = 1;
        for (long i = 1; i < to; i++) {
            result *= i;
        }
        return result;
    }
}
