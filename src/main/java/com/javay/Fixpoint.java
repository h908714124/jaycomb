package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class Fixpoint {

    private static <T, R> Function<UnaryOperator<Function<T, R>>, Function<T, R>> create() {
        return r -> {
            SelfApply<T, R> self1 = SelfApply.create(UnaryOperator.identity());
            SelfApply<T, R> self2 = SelfApply.create(r);
            return self1.apply(self2);
        };
    }

    static <T, R> Function<T, R> recursify(BiFunction<Function<T, R>, T, R> r) {
        UnaryOperator<Function<T, R>> operator = f -> t -> r.apply(f, t);
        return Fixpoint.<T, R>create().apply(operator);
    }
}
