package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class FixpointFactory<T, R> {

    private UnaryOperator<Function<T, R>> r;

    private FixpointFactory(UnaryOperator<Function<T, R>> r) {
        this.r = r;
    }

    // Creates a fixpoint of r.
    private Function<T, R> createFixpoint() {
        return r.apply(this::apply);
    }

    private R apply(T t) {
        return createFixpoint().apply(t);
    }

    // Convenient recursifier. The resulting function can cause stack overflow.
    static <T, R> Function<T, R> recursify(BiFunction<Function<T, R>, T, R> rr) {
        UnaryOperator<Function<T, R>> r = f -> t -> rr.apply(f, t);
        return new FixpointFactory<>(r).createFixpoint();
    }
}
