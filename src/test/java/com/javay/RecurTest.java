package com.javay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.math.BigInteger.ONE;

class RecurTest {

    private BigInteger pseudoAdd(Function<Entry<BigInteger, BigInteger>, BigInteger> f, Entry<BigInteger, BigInteger> n) {
        if (n.getKey().equals(BigInteger.ZERO)) {
            return n.getValue();
        }
        return f.apply(new SimpleImmutableEntry<>(n.getKey().subtract(ONE), n.getValue().add(ONE)));
    }

    private Function<Entry<BigInteger, BigInteger>, BigInteger> add = PseudoRecursive.recursify(this::pseudoAdd);

    @Test
    void testAdd() {
        Assertions.assertEquals(BigInteger.valueOf(4), add.apply(new SimpleImmutableEntry<>(BigInteger.valueOf(11), BigInteger.valueOf(-7))));
    }
}