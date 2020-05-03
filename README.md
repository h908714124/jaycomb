### Y Combinator

http://www.righto.com/2009/03/y-combinator-in-arc-and-java.html

Fixpoint is very easy in Java:

````java
class Fixpoint<T, R> implements Function<T, R> {

    private BiFunction<Function<T, R>, T, R> r;

    // Create a recursive version of r.
    Fixpoint(BiFunction<Function<T, R>, T, R> r) {
        this.r = r;
    }

    @Override
    public R apply(T t) {
        return r.apply(this, t);
    }
}
````

This can be used as follows:

````java
Function<BigInteger, BigInteger> fact = new Fixpoint<>((f, n) -> {
    if (n.equals(ZERO)) {
        return ONE;
    }
    return n.multiply(f.apply(n.subtract(ONE)));
});
Assertions.assertEquals(BigInteger.valueOf(120), fact.apply(BigInteger.valueOf(5)));
````

See the test folder for more usage examples.

