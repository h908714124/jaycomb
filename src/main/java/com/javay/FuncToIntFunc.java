package com.javay;

// Self referential type!
interface FuncToIntFunc {

    IntFunc apply(FuncToIntFunc x);
}
