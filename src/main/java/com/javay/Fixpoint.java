package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;

class Fixpoint<T, R> implements Function<T, R> {

    private BiFunction<Function<T, R>, T, R> r;

    // Create a recursive version of r.
    Fixpoint(BiFunction<Function<T, R>, T, R> r) {
        this.r = r;
    }

    @Override
    public R apply(T t) {
        return r.apply(this, t);
    }
}
