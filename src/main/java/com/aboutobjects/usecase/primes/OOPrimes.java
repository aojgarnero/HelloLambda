package com.aboutobjects.usecase.primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OOPrimes {


    public List<Integer> apply (int upTo) {

        if (upTo <= 0) return List.of();

        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = sieve(upTo);
        for (int i = 1; i <= upTo; i++) if (isPrime[i]) primes.add (i) ;

        return primes;

    }

    public boolean [] sieve (int n) {

        boolean[] isPrime = new boolean [n + 1] ;
        Arrays.fill (isPrime, true) ; // All primes unless proven otherwise.

        isPrime [0] = false ;
        isPrime [1] = false ;

        for (int p = 2; p <= n; p++) {
            if (isPrime [p]) {
                for (int i = 2 * p; i <= n; i = i + p)
                    isPrime [i] = false;
            }
        }

        return isPrime;
    }
}
