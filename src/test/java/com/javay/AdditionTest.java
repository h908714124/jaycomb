package com.javay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

class AdditionTest {

    private BigInteger radd(Function<Entry<BigInteger, BigInteger>, BigInteger> f, Entry<BigInteger, BigInteger> n) {
        if (n.getKey().equals(ZERO)) {
            return n.getValue();
        }
        return f.apply(pair(n.getKey().subtract(ONE), n.getValue().add(ONE)));
    }

    private Function<Entry<BigInteger, BigInteger>, BigInteger> add = new Fixpoint<>(this::radd);

    @Test
    void testAdd() {
        Assertions.assertEquals(BigInteger.valueOf(4), add.apply(pair(11, -7)));
        Assertions.assertEquals(BigInteger.valueOf(10), add.apply(pair(1, 9)));
    }

    private static Entry<BigInteger, BigInteger> pair(int n1, int n2) {
        return new SimpleImmutableEntry<>(BigInteger.valueOf(n1), BigInteger.valueOf(n2));
    }

    private static Entry<BigInteger, BigInteger> pair(BigInteger n1, BigInteger n2) {
        return new SimpleImmutableEntry<>(n1, n2);
    }
}