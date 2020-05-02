package com.javay;

import java.util.function.Function;
import java.util.function.UnaryOperator;

interface SelfApply<T, R> {

    // Self referential method, a necessary evil?
    Function<T, R> apply(SelfApply<T, R> x);

    static <T, R> SelfApply<T, R> create(UnaryOperator<Function<T, R>> r) {
        return self -> {
            Function<T, R> f = t -> {
                Function<T, R> g = self.apply(self);
                return g.apply(t);
            };
            // It seems like r.apply(self.apply(self)) would be equivalent, but...
            return r.apply(f);
        };
    }
}
