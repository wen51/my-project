package com.jw.myproject.myproject.test.finals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalTest {

    private final int[] i;

    static FinalTest finalTest;

    public FinalTest() {
        Logger l = LoggerFactory.getLogger(FinalTest.class);
        i = new int[1];
    }
}
