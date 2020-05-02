package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class FixpointFactory<T, R> {

    private UnaryOperator<Function<T, R>> r;

    FixpointFactory(BiFunction<Function<T, R>, T, R> r) {
        this.r = f -> t -> r.apply(f, t);
    }

    // Creates a fixpoint of r.
    Function<T, R> createFixpoint() {
        return r.apply(this::iterate);
    }

    private R iterate(T t) {
        return createFixpoint().apply(t);
    }
}
