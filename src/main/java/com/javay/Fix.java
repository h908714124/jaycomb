package com.javay;

import java.util.function.UnaryOperator;

class Fix {

    private static final FuncToIntFunc SELF_APPLY = f -> f.apply(f);

    private static FuncToIntFunc funcToIntFunc(UnaryOperator<IntFunc> r) {
        return f -> r.apply(x -> SELF_APPLY.apply(f).apply(x));
    }

    static final IntFuncOperatorToIntFunc FIX = r -> SELF_APPLY.apply(funcToIntFunc(r));
}
