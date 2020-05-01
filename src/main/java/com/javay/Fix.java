package com.javay;

class Fix {

    private static final FuncToIntFunc SELF_APPLY = f -> f.apply(f);

    static final IntFuncToIntFuncToIntFunc FIX = r -> SELF_APPLY
            .apply(f -> r.apply(x -> SELF_APPLY.apply(f).apply(x)));

}
