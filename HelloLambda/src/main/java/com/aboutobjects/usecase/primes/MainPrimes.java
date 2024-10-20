package com.aboutobjects.usecase.primes;


import java.util.List;

public class MainPrimes {

    public static void main (String flag) {

        if ("lambda".equals(flag)) {
            System.out.println ("Functional wise") ;
            LambdaPrimes lambdaPrimes = new LambdaPrimes();
            List<Integer> primes = lambdaPrimes.apply(100);
            primes.forEach(System.out::println);
        } else {
            System.out.println ("Object Oriented wise") ;
            OOPrimes ooPrimes = new OOPrimes();
            List<Integer> primes = ooPrimes.apply(100);
            primes.forEach(System.out::println);
        }

    }

}
