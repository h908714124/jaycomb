package com.javay;

import java.util.function.Function;

// Self referential type!
interface SelfApply<T, R> {

    Function<T, R> apply(SelfApply<T, R> x);

    static <T, R> SelfApply<T, R> create() {
        return f -> f.apply(f);
    }
}
