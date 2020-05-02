package com.javay;

import java.util.function.Function;
import java.util.function.UnaryOperator;

interface PseudoRecursive<T, R> {

    R apply(Function<T, R> f, T t);

    static <T, R> Function<T, R> recursify(PseudoRecursive<T, R> r) {
        UnaryOperator<Function<T, R>> operator = f -> t -> r.apply(f, t);
        return Fixpoint.<T, R>create().apply(operator);
    }
}
