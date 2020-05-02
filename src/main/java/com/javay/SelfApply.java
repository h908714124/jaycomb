package com.javay;

import java.util.function.Function;
import java.util.function.UnaryOperator;

interface SelfApply<T, R> {

    // Self referential method, a necessary evil?
    Function<T, R> apply(SelfApply<T, R> x);

    // λf.(f f)
    static <T, R> SelfApply<T, R> createEager() {
        return f -> f.apply(f);
    }

    // λf.(r λx.((f f) x)
    static <T, R> SelfApply<T, R> createLazy(UnaryOperator<Function<T, R>> r) {
        return f -> {
            Function<T, R> lazy = x -> {
                Function<T, R> eager = f.apply(f);
                return eager.apply(x);
            };
            return r.apply(lazy);
        };
    }
}
