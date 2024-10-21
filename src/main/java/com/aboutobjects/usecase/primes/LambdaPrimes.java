package com.aboutobjects.usecase.primes;

import java.util.List;
import java.util.stream.IntStream;

public class LambdaPrimes {

    public List<Integer> apply (int upTo) {

        return IntStream.range(1, upTo + 1).filter(this::isPrime).boxed().toList();
        // very costly.

    }

    public boolean isPrime(int i) {
        if (i == 1) return false ;
        if (i == 2) return true  ;
        return IntStream.range (2, i / 2 + 1).allMatch (div -> i % div != 0) ;
    }

}
