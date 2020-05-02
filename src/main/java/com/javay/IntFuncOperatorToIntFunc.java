package com.javay;

import java.util.function.UnaryOperator;

// ((int -> int) -> (int -> int)) -> (int -> int)
interface IntFuncOperatorToIntFunc {

    IntFunc apply(UnaryOperator<IntFunc> r);
}
