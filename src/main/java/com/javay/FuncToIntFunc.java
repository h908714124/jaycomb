package com.javay;

// Higher-order function returning an int function
// F: F -> (int -> int)
interface FuncToIntFunc {
    
    IntFunc apply(FuncToIntFunc x);
}
