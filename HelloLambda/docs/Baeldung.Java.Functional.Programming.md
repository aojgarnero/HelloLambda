## Functional Programming in Java. (baeldung).

A summary from [Baeldung:Functional Programming in Java](https://www.baeldung.com/java-functional-programming)

1. `first-class functions` if language treats functions as `first-class citizens`.

This means that functions are allowed to support all operations
typically available to other entities. 
These include assigning functions to variables, passing them as arguments to other functions and returning them as values from other functions.

2. `pure functions`  
  - return values based *on the arguments only* and 
  - should have _no side effects_
3. `Immutability` 
  - entity can’t be modified after being instantiated.
4. an expression is `referentially transparent` if replacing it with its corresponding value has no impact on the program’s behavior.

`pure functions` + `immutability` <==> `referential transparency`

## Techniques

### Composition.

A complex function can be written as the composition of simpler ones.

`Functional interfaces` = target types for lambda expressions and method references.

Typically, any interface with a single abstract method can serve as a functional interface. 

So, we can define a functional interface quite easily.

However, Java 8 provides many `functional interfaces` by default for different use cases under `java.util.function`.

some functional interfaces:
 
* `Function<Double, Double> log = (value) *> Math.log(value);`
* `Function<Double, Double> sqrt = (value) *> Math.sqrt(value);`
* `Function<Double, Double> logThenSqrt = sqrt.`*compose*`(log);`
* `logger.log(Level.INFO, String.valueOf(logThenSqrt.apply(3.14)));`
* `// Output: 1.06`
* `Function<Double, Double> sqrtThenLog = sqrt.`*andThen*`(log);`
* `logger.log(Level.INFO, String.valueOf(sqrtThenLog.apply(3.14)));`
* `// Output: 0.57`

`compose` applies `log` function first.

`andThen` applies `sqrt` first.

### Monads

I prefer the other explanation, check 2nd part of readme.

Still. A Monad should follow:

* left identity
* right identity 
* associativity

### Currying

Mathematical technique of converting a function that takes `multiple arguments` 

into a sequence of functions that take a `single argument`.

### Recursion

Ya sabes que es recursion. Pero `tail recursion` ? Hablarlo con el grupo.

## Why Functional Programming Matters

* pure functions 
* immutable states
* easier to read, reason about, test and maintain programs
* concise & readable code.

## Is Java a Suitable Fit?

Java was designed to be OO, and 'classes' are the true first class citizens of the language. 

Therefore there are many aspects of Java that do not fit perfectly in the functional programming paradigm.

But since Java 8, existing Java programs can greatly benefit from functional programing practices.








