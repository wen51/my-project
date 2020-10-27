package com.jw.myproject.test.finals;

import org.slf4j.LoggerFactory;

public class FinalTest {

    private final int[] i;

    static FinalTest finalTest;

    public FinalTest() {
        LoggerFactory l = LoggerFactory.getLogger();
        i = new int[1];
    }
}
