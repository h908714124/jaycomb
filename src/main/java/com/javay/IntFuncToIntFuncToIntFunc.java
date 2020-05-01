package com.javay;

// Function from IntFuntToIntFunc to IntFunc
// ((int -> int) -> (int -> int)) -> (int -> int)
interface IntFuncToIntFuncToIntFunc {

    IntFunc apply(IntFuncToIntFunc r);
}
