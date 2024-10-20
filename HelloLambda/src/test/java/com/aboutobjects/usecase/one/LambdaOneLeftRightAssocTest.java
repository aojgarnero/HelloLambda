package com.aboutobjects.usecase.one;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;

class LambdaOneLeftRightAssocTest {

    private final LambdaOne lambda1 = new LambdaOne() ;

    @Test
    void optionalStillMonadUsingMyLambdaOne () {    // Monad properties survive my lambda coding.

        leftIdentity    ()  ;
        rightIdentity   ()  ;
        associativity   ()  ;

    }

    void leftIdentity () {

        String input = "4/2";

        Optional<String> opt = Optional.of (input);
        Function<String, Optional<Double>> f = x -> lambda1.apply (x) ;

        Optional<Double> result1 = opt.flatMap (f) ;
        Optional<Double> result2 = lambda1.apply (input) ;

        assert result1.equals (result2);
        assert result1.equals (Optional.of (2.0));

    }

    void rightIdentity () {

        String input = "bla,bla";   // lambda1 doesn't play here.

        Optional<String> opt    = Optional.of (input);
        Optional<String> result = opt.flatMap(Optional::of);

        assert result.equals (opt) ;
        assert result.equals (Optional.of(input)) ;

    }

    void associativity () {     // let's compose lambda1 with a "plus one" function. ("p").

        String input = "4/2";

        Optional<String> opt = Optional.of (input);
        Function<String, Optional<Double>> f  = x -> lambda1.apply (x) ;
        Function<Double, Optional<Double>> p = x -> Optional.of (x + 1) ;

        Optional<Double> result1 = opt.flatMap (f).flatMap (p) ;
        Optional<Double> result2 = opt.flatMap (x -> f.apply (x).flatMap (p)) ;

        assert result1.equals (result2) ; // Both will contain Optional.of(3.0)
        assert result1.equals (Optional.of (3.0)) ;

    }

}
