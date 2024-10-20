package com.aboutobjects.usecase.one;

import java.util.Optional;

public class MainUseCaseOne {

    public static void main (String flag) {

        String input = "200/100" ;  // 200 / 100 = 2
        System.out.println ("Hello User Case One") ;

        if ("lambda".equals(flag)) {
            System.out.println("Using functional programming.");
            LambdaOne lambda = new LambdaOne ();
            System.out.printf ("Input:<%s> (should result a '2')%n", input);
            Optional<Double> result = lambda.apply (input) ;
            System.out.printf ("Result:%s%n", (result.isPresent()) ? String.format("%10.2f", result.get()): "Result not present.");
            return;
        }

        System.out.println ("Using oo programming.") ;
        OOrientedOne oOrientedOne = new OOrientedOne();
        System.out.printf ("Input:<%s> (should result a '2')%n", input) ;
        System.out.printf ("Result:%10.2f%n", oOrientedOne.apply(input)) ;

    }

}
