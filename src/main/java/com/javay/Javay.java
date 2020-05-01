package com.javay;

import static com.javay.Fix.FIX;

class Javay {

    private static int fact(IntFunc f, int n) {
        if (n == 0) {
            return 1;
        }
        return n * f.apply(n - 1);
    }

    static int factorial(int input) {
        IntFunc intFunc = FIX.apply(f -> n -> fact(f, n));
        return intFunc.apply(input);
    }
}
