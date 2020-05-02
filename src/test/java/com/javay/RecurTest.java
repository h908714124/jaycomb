package com.javay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecurTest {

    private static int fact(IntFunc f, int n) {
        if (n == 0) {
            return 1;
        }
        return n * f.apply(n - 1);
    }

    @Test
    void factTest() {
        Assertions.assertEquals(120, Recur.recur(RecurTest::fact, 5));
    }
}