package com.javay;

// Function on int function returning an int function
// (int -> int) -> (int -> int)
interface IntFuncToIntFunc {

    IntFunc apply(IntFunc f);
}
