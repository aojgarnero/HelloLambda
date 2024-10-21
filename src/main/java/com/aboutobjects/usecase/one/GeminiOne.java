package com.aboutobjects.usecase.one;

import java.util.function.Function;

public class GeminiOne {

    private static Function<String     ,   String[]>   splitter    = s -> s.split ("/") ;
    private static Function<String[]   ,   double[]>   parser      = s -> new double [] { Double.parseDouble (s [0]), Double.parseDouble (s [1]) } ;
    private static Function<double[]   ,   Double>     divider     = s -> s [0] / s [1] ;
    private static Function<String     ,   Double>     f           = divider.compose(parser.compose(splitter)) ;

    public double apply(String s) {
        return f.apply (s) ;
    }
}
