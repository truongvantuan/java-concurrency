package com.company.javaconcurrencylearning.threadproblem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceConditionExample3 {

    public static void main(String[] args) {

        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        var thread1 = new Thread(getRunnable(sharedMap));
        var thread2 = new Thread(getRunnable(sharedMap));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                if (sharedMap.containsKey("key")) {
                    var val = sharedMap.remove("key");
                    if (val == null) {
                        System.out.println("Iteration: " + i + " Value is null");
                    }
                } else {
                    sharedMap.put("key", "value");
                }
            }
        };
    }
}
