package com.aboutobjects.usecase.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeminiOneTest {

    private final GeminiOne g1 = new GeminiOne ();

    @Test
    void applyTest () {
        assertEquals (2.0, g1.apply ("200/100")) ;
        assertEquals (4.0, g1.apply ("64/16"  )) ;
    }

    @Test
    void applyDivideByZeroTest () {
        assertEquals (Double.POSITIVE_INFINITY, g1.apply ("64/0"  )) ;
        assertEquals (Double.NEGATIVE_INFINITY, g1.apply ("-64/0"  )) ;
        assertEquals (Double.NaN, g1.apply ("0/0"  )) ;
    }

    @Test
    void exceptionParseTest () {

        Exception exception = assertThrows (NumberFormatException.class, () -> g1.apply("abc/xyz"));
        assertEquals("For input string: \"abc\"", exception.getMessage());

    }

    @Test
    void exceptionSplitTest () {

        Exception exception = assertThrows (NumberFormatException.class, () -> g1.apply("12|6"));
        assertEquals("For input string: \"12|6\"", exception.getMessage());

    }

    @Test
    void exceptionEmptyTest () {

        Exception exception = assertThrows (NumberFormatException.class, () -> g1.apply(""));
        assertEquals("empty String", exception.getMessage());

    }

    @Test
    void exceptionNullTest () {

        Exception exception = assertThrows (NullPointerException.class, () -> g1.apply(null));
        assertEquals("Cannot invoke \"String.split(String)\" because \"s\" is null", exception.getMessage());

    }

}
