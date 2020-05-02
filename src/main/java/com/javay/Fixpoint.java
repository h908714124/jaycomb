package com.javay;

import java.util.function.Function;
import java.util.function.UnaryOperator;

class Fixpoint {

    private static <T, R> SelfApply<T, R> funcToIntFunc(UnaryOperator<Function<T, R>> r) {
        return f -> r.apply(x -> SelfApply.<T, R>create().apply(f).apply(x));
    }

    static <T, R> Function<UnaryOperator<Function<T, R>>, Function<T, R>> create() {
        return r -> SelfApply.<T, R>create().apply(funcToIntFunc(r));
    }
}
