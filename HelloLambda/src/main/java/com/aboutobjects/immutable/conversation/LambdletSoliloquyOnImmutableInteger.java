package com.aboutobjects.immutable.conversation;

public class LambdletSoliloquyOnImmutableInteger {

    public static void main () {

        System.out.println () ;
        System.out.println ("#################################################") ;
        System.out.println ("   To mutate, or not to mutate ?.") ;
        System.out.println ("   This is an analisis. With 'Integer':") ;
        System.out.println ("#################################################") ;
        System.out.println () ;

        System.out.println ("------Let's declare two variables") ;
        System.out.println ("Integer originalTen = Integer.valueOf(10);") ;
        System.out.println ("Integer ten         = originalTen ;") ;
        Integer originalTen = Integer.valueOf(10);
        Integer ten         = originalTen ;
        System.out.println ("------Let's print it.") ;
        System.out.printf ("originalTen=%d. ten=%d%n", originalTen, ten) ;
        System.out.println ("------Ok, you have two 'Integer' variables. Both 10.") ;
        System.out.println () ;
        System.out.println () ;
        System.out.println ("--------- Now.") ;

        // there is not 'set' method.
        // so, you cannot change its content, but ...
        System.out.println ("--------- there is not 'set' method.") ;
        System.out.println ("--------- so, you cannot change its content directly, but if you code:") ;
        System.out.println ("originalTen = Integer.valueOf(1);") ;
        originalTen = Integer.valueOf(1);
        System.out.println ("--------- and then print it, you get:") ;
        System.out.printf  ("originalTen= %d.%n", originalTen);
        System.out.println () ;
        System.out.printf  ("--------- Whooo! it was changed! Now it points to '1'.%n");
        System.out.printf  ("--------- Let's print the other variable 'ten'.%n");
        System.out.printf  ("ten= %d.%n", ten);
        System.out.printf  ("--------- Ok, the second variable 'ten' remained 10. Cool.%n");

        System.out.println () ;
        System.out.printf  ("--------- Now, let's declare variable 'nine'.Like:%n");
        System.out.printf  ("--------- (notice the keyword 'final')%n");
        System.out.printf  ("final Integer nine = Integer.valueOf(9);%n");
        final Integer nine = Integer.valueOf(9);
        // nine = Integer.valueOf(1) ;
        // Nope!! Compile error: "cannot assign a value to final variable 'nine'"
        System.out.printf  ("--------- and then try to reassign.%n");
        System.out.printf  ("--------- nine = Integer.valueOf(1) ;%n");
        System.out.printf  ("--------- Nope!! Compile error: \"cannot assign a value to final variable 'nine'%n");
        System.out.printf  ("--------- if you print of course it has the right value, 9.%n");
        System.out.printf  ("nine= %d%n", nine);

        System.out.println ("....Conclusion:") ;
        System.out.println ("....You cannot change an 'Integer' object directly because is Immutable. ") ;
        System.out.println ("....However, you can do it indirectly by reassigning the variable");
        System.out.println ("....you can prevent this by declaring your variable \"final\"") ;
        System.out.println ("....Note:") ;
        System.out.println ("....The change in variable `originalTen` doesn't contradict `Integer`'s immutability. ") ;
        System.out.println ("....Simply the variable 'originalTen' was assigned, pointed to a new Integer, Integer.valueOf(1).") ;
        System.out.println ("....The first content of 'originalTen' didn't change, as printing he var 'ten' proves.") ;
        System.out.println ("....To avoid such assignments, you can use the keyword `final`.") ;
        System.out.println ("....For instance, the first line of code the following code is safe, but the 2nd line,") ;
        System.out.println ("....can be modified, resulting in a potential misleading variable.\n") ;
        System.out.println ("    private static final Integer NUMBER_OF_DAYS_IN_A_WEEK = Integer.valueOf(7); // safe.") ;
        System.out.println ("    private static       Integer Number_Of_Days_In_A_Week = Integer.valueOf(7); // unsafe.") ;
        System.out.println ("    ...") ;
        System.out.println ("    Integer Number_Of_Days_In_A_Week = 2 ; // ouch!!.") ;


    }

}
