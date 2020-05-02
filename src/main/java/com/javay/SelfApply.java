package com.javay;

import java.util.function.Function;
import java.util.function.UnaryOperator;

// Self referential type!
interface SelfApply<T, R> {

    Function<T, R> apply(SelfApply<T, R> x);

    // "paradoxical" factory
    static <T, R> SelfApply<T, R> create(UnaryOperator<Function<T, R>> r) {
        return self -> {
            Function<T, R> f = t -> {
                Function<T, R> g = self.apply(self);
                return g.apply(t);
            };
            // It looks like r.apply(self.apply(self)) would be equivalent here, but that leads to stack overflow!
            return r.apply(f);
        };
    }
}
