package com.javay;

import java.util.function.Function;
import java.util.function.UnaryOperator;

// Self referential type!
interface SelfApply<T, R> {

    Function<T, R> apply(SelfApply<T, R> x);

    // "paradoxical" factory
    static <T, R> SelfApply<T, R> create(UnaryOperator<Function<T, R>> r) {
        return self -> r.apply(x -> {
            Function<T, R> f = self.apply(self);
            return f.apply(x);
        });
    }
}
