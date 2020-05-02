package com.javay;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class Fixpoint {

    // Creates a fixpoint of r.
    private static <T, R> Function<T, R> create(UnaryOperator<Function<T, R>> r) {
        SelfApply<T, R> f = SelfApply.create(r);
        // (λf.(r λx.((f f) x)) λf.(r λx.((f f) x)
        return f.apply(f);
    }

    // Convenient recursifier, but note that the resulting function can overflow the stack.
    static <T, R> Function<T, R> recursify(BiFunction<Function<T, R>, T, R> r) {
        UnaryOperator<Function<T, R>> operator = f -> t -> r.apply(f, t);
        return Fixpoint.create(operator);
    }
}
