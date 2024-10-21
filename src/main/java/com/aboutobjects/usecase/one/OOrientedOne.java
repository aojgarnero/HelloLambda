package com.aboutobjects.usecase.one;

public class OOrientedOne {

    private double divide (double [] input) {       // function instead of operator "/".
        return input [0] / input [1] ;
    }

    private double [] parse (String [] input) {     // change content, not structure ...

        double [] output = new double [2];
        output [0] = Double.parseDouble (input [0]) ;
        output [1] = Double.parseDouble (input [1]) ;

        return output ;

    }

    private String [] split (String input) {    // could be used directly, just for clarity.
        return input.split ("/") ;
    }

    public double apply (String input) {        // composition: divide o parse o split
                                                // "divide after parse after split".
        return divide (parse (split (input))) ;
    }

}
