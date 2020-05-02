package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;

class Fixpoint<T, R> implements Function<T, R> {

    private Function<T, R> f;

    // Create a recursive version of r.
    Fixpoint(BiFunction<Function<T, R>, T, R> r) {
        f = t -> r.apply(f, t);
    }

    @Override
    public R apply(T t) {
        return f.apply(t);
    }
}
