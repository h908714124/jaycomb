package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;

class Fixpoint<T, R> implements Function<T, R> {

    private Function<T, R> fixpoint;

    // Create a recursive version of r.
    Fixpoint(BiFunction<Function<T, R>, T, R> r) {
        this.fixpoint = t -> r.apply(fixpoint, t);
    }

    @Override
    public R apply(T t) {
        return fixpoint.apply(t);
    }
}
