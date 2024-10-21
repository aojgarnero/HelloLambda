# Hello Lambda

A learning project to exercise functional programming in Java.

## Intro

This is a good intro for [Functional Programming in Java.(*Baeldung*)](docs/Baeldung.Java.Functional.Programming.md).

The topic of `immutable` classes can also be read [Mutable vs. Immutable Objects in Java(*Baeldung*)](https://www.baeldung.com/java-mutable-vs-immutable-objects#:~:text=In%20Java%2C%20the%20Integer%20class,created%20to%20hold%20the%20result.&text=Here%2C%20the%20%2B%20operation%20creates%20a,the%20original%20object%20remains%20immutable.)

## Use Cases

### Use Case `One`.

After listening to [No Nonsense Monad & Functor - The foundation of Functional Programming](https://www.youtube.com/watch?v=e6tWJD5q8uw)
(by *César Tron-Lozai*),

I decided to give myself the task of java coding the presented use case.

See [here](docs/NoNonsenseMonad&Functor.md).

### `Primes` Use Case.

The problem of `finding all primes numbers up to N` solved:

* Imperative, Object Oriented like, in `OOPrimes.java`.
* Functional in `LambdaPrimes.java`.

### `Hanoi Towers Recursion` Use Case.

The `Towers of Hanoi` problem, solved by recursion.

### `Hanoi Currying` Use Case.

Since the Hanoi problem came handy, the definition of functions to calculate moves.

First, as a two argument function `move` , that returns a Hanoi Tower from a command and a Hanoi Tower.

Then as a *one argument* set of functions, like `ab` (move from tower A to tower B), `ac`, `ba`, etc.

Also defining it with `UnaryOperator` functional interface.

### `Self Conversation about Immutable` Use Case.

`Integer` class is immutable.

Which means you cannot change the internal state of an `Integer` object.

*But* ... you can reassign an `Integer` variable.

`final` keyword to the rescue ...

Read and enjoy Lambdlet's soliloquy: to *mutate* or *not to mutate*: that is the question ... 

