package com.aboutobjects.usecase.primes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LambdaPrimesTest {      // from Google AI.

    @Test
    void LambdaPrimesIsPrimeTest () {

        LambdaPrimes lambdaPrimes = new LambdaPrimes () ;

        assert ( ! lambdaPrimes.isPrime ( 1)) ;
        assert (   lambdaPrimes.isPrime ( 2)) ;
        assert (   lambdaPrimes.isPrime ( 3)) ;
        assert ( ! lambdaPrimes.isPrime ( 4)) ;
        assert (   lambdaPrimes.isPrime ( 5)) ;
        assert ( ! lambdaPrimes.isPrime ( 6)) ;
        assert (   lambdaPrimes.isPrime ( 7)) ;
        assert ( ! lambdaPrimes.isPrime ( 8)) ;
        assert ( ! lambdaPrimes.isPrime ( 9)) ;
        assert ( ! lambdaPrimes.isPrime (10)) ;

    }

    @Test
    void LambdaPrimesApplyTest () {

        LambdaPrimes lambdaPrimes = new LambdaPrimes () ;

        assertEquals (List.of (2,3,5,7), lambdaPrimes.apply (10)) ;
        assertEquals (List.of (2, 3, 5, 7, 11, 13, 17, 19, 23, 29), lambdaPrimes.apply (30)) ;
        assertEquals (List.of (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97), lambdaPrimes.apply(100));

    }

    @Test
    void LambdaPrimesApplyBorderCasesTest () {

        LambdaPrimes lambdaPrimes = new LambdaPrimes () ;

        assertEquals (List.of (), lambdaPrimes.apply (-2)) ;
        assertEquals (List.of (), lambdaPrimes.apply (-1)) ;
        assertEquals (List.of (), lambdaPrimes.apply ( 0)) ;
        assertEquals (List.of (), lambdaPrimes.apply ( 1)) ;
        assertEquals (List.of (2), lambdaPrimes.apply ( 2)) ;
        assertEquals (List.of (2,3), lambdaPrimes.apply ( 3)) ;
        assertEquals (List.of (2,3), lambdaPrimes.apply ( 4)) ;
        assertEquals (List.of (2,3,5), lambdaPrimes.apply ( 5)) ;

    }

}
