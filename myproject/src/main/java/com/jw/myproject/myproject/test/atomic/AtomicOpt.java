package com.jw.myproject.myproject.test.atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicOpt {

    public static AtomicLong largest = new AtomicLong();

    public static void setValue(long m) {
        long oldValue = 0;
        long newValue = 0;
        do {
//            oldValue = largest.get();
//            newValue = oldValue + m;
            System.out.println(largest.incrementAndGet());
        } while (!largest.compareAndSet(oldValue, newValue));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                long m = (long) (Math.random() * 100000);
                setValue(m);
            }).start();
        }

    }
}
