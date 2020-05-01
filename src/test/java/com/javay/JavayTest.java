package com.javay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavayTest {

    @Test
    void factTest() {
        Assertions.assertEquals(120, Javay.factorial(5));
    }
}