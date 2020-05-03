package com.javay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.function.Function;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

class FactorialTest {

    BigInteger rfact(Function<BigInteger, BigInteger> f, BigInteger n) {
        if (n.equals(ZERO)) {
            return ONE;
        }
        return n.multiply(f.apply(n.subtract(ONE)));
    }

    Function<BigInteger, BigInteger> fact = new Fixpoint<>(this::rfact);

    @Test
    void testFact() {
        Assertions.assertEquals(BigInteger.valueOf(120), fact.apply(BigInteger.valueOf(5)));
    }
}