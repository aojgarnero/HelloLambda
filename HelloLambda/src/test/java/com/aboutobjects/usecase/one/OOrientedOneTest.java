package com.aboutobjects.usecase.one;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OOrientedOneTest {

    private final OOrientedOne uc1 = new OOrientedOne() ;

    @Test
    void applyTest () {
        assertEquals (2.0, uc1.apply ("200/100")) ;
        assertEquals (4.0, uc1.apply ("64/16"  )) ;
    }

    @Test
    void applyDivideByZeroTest () {
        assertEquals (Double.POSITIVE_INFINITY, uc1.apply ("64/0"  )) ;
        assertEquals (Double.NEGATIVE_INFINITY, uc1.apply ("-64/0"  )) ;
        assertEquals (Double.NaN, uc1.apply ("0/0"  )) ;
    }

    @Test
    void exceptionParseTest () {

        Exception exception = assertThrows (NumberFormatException.class, () -> uc1.apply("abc/xyz"));
        assertEquals("For input string: \"abc\"", exception.getMessage());

    }

    @Test
    void exceptionSplitTest () {

        Exception exception = assertThrows (NumberFormatException.class, () -> uc1.apply("12|6"));
        assertEquals("For input string: \"12|6\"", exception.getMessage());

    }

    @Test
    void exceptionEmptyTest () {

        Exception exception = assertThrows (NumberFormatException.class, () -> uc1.apply(""));
        assertEquals("empty String", exception.getMessage());

    }

    @Test
    void exceptionNullTest () {

        Exception exception = assertThrows (NullPointerException.class, () -> uc1.apply(null));
        assertEquals("Cannot invoke \"String.split(String)\" because \"input\" is null", exception.getMessage());

    }

}
