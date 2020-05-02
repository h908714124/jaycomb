package com.javay;

import static com.javay.Fix.FIX;

class Recur {

    static int recur(RecursiveFunc r, int input) {
        IntFunc intFunc = FIX.apply(f -> n -> r.apply(f, n));
        return intFunc.apply(input);
    }
}
