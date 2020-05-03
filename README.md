### Y Combinator

http://www.righto.com/2009/03/y-combinator-in-arc-and-java.html

Fixpoint can be implemented very simple in Java:

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

See the test folder for a usage example.