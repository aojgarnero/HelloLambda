package com.aboutobjects.usecase.primes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OOPrimesTest {      // from Google AI.

    @Test
    void OOPrimesIsPrimeTest () {

        OOPrimes ooPrimes = new OOPrimes () ;

        boolean[] isPrime = ooPrimes.sieve (100);

        assert ( ! isPrime [ 1]) ;
        assert (   isPrime [ 2]) ;
        assert (   isPrime [ 3]) ;
        assert ( ! isPrime [ 4]) ;
        assert (   isPrime [ 5]) ;
        assert ( ! isPrime [ 6]) ;
        assert (   isPrime [ 7]) ;
        assert ( ! isPrime [ 8]) ;
        assert ( ! isPrime [ 9]) ;
        assert ( ! isPrime [10]) ;

    }

    @Test
    void OOPrimesApplyTest () {

        OOPrimes ooPrimes = new OOPrimes () ;

        assertEquals (List.of (2,3,5,7), ooPrimes.apply (10)) ;
        assertEquals (List.of (2, 3, 5, 7, 11, 13, 17, 19, 23, 29), ooPrimes.apply (30)) ;
        assertEquals (List.of (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97), ooPrimes.apply(100));

    }

    @Test
    void OOPrimesApplyBorderCasesTest () {

        OOPrimes ooPrimes = new OOPrimes();

        assertEquals (List.of (), ooPrimes.apply (-2)) ;
        assertEquals (List.of (), ooPrimes.apply (-1)) ;
        assertEquals (List.of (), ooPrimes.apply ( 0)) ;
        assertEquals (List.of (), ooPrimes.apply ( 1)) ;
        assertEquals (List.of (2), ooPrimes.apply ( 2)) ;
        assertEquals (List.of (2,3), ooPrimes.apply ( 3)) ;
        assertEquals (List.of (2,3), ooPrimes.apply ( 4)) ;
        assertEquals (List.of (2,3,5), ooPrimes.apply ( 5)) ;

    }

}
