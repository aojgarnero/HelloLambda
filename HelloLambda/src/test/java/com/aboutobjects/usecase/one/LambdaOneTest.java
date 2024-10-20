package com.aboutobjects.usecase.one;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

class LambdaOneTest {

    private final LambdaOne lambda1 = new LambdaOne() ;

    @Test
    void applyTest () {

        //--- Only difference with the OO test is expected=Optional.of(2), instead of just 2.
        assertEquals (Optional.of (2.0), lambda1.apply ("200/100")) ;
        assertEquals (Optional.of (4.0), lambda1.apply ("64/16")) ;

    }

    @Test
    void applyDivideByZeroTest () {

        //--- Same as "applyTest", previous test.
        // Only difference with the OO test is, expected=Optional.of ... instead of just the double.
        assertEquals (Optional.of (Double.POSITIVE_INFINITY) ,   lambda1.apply ("64/0"  )) ;
        assertEquals (Optional.of (Double.NEGATIVE_INFINITY) ,   lambda1.apply ("-64/0" )) ;
        assertEquals (Optional.of (Double.NaN)               ,   lambda1.apply ("0/0"   )) ;

    }

    @Test
    void exceptionParseTest () {

        // Same as OO test.
        Exception exception = assertThrows (NumberFormatException.class, () -> lambda1.apply("abc/xyz"));
        assertEquals("For input string: \"abc\"", exception.getMessage());

    }

    @Test
    void exceptionSplitTest () {

        // Same as OO test.
        Exception exception = assertThrows (NumberFormatException.class, () -> lambda1.apply("12|6"));
        assertEquals("For input string: \"12|6\"", exception.getMessage());

    }

    @Test
    void exceptionEmptyTest () {

        // Same as OO test.
        Exception exception = assertThrows (NumberFormatException.class, () -> lambda1.apply(""));
        assertEquals("empty String", exception.getMessage ());

    }

    @Test
    void exceptionNullTest () {

        // Different exception from OO, but arguably better than NullPointerException.
        // the 'get' in the Optional.of indicates 'NoSuchElement', which is exactly the case.
        Exception exception = assertThrows (NoSuchElementException.class, () -> lambda1.apply(null));
        assertEquals("No value present", exception.getMessage ());

    }

}
