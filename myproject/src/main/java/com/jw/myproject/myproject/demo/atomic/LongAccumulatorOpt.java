package com.jw.myproject.myproject.demo.atomic;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorOpt {

    public static void main(String[] args) {
        LongAccumulator adder = new LongAccumulator(Long :: sum, 0);
        for (int i=0; i<1000; i++){
            new Thread(() -> {
                adder.accumulate(100);
                System.out.println(adder.get());
            }).start();
        }
    }
}
