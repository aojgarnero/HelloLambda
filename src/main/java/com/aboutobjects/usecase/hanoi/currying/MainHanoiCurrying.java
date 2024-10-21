package com.aboutobjects.usecase.hanoi.currying;

import com.aboutobjects.usecase.hanoi.recursion.HanoiTowers;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MainHanoiCurrying {

    public static void main () {

        HanoiMover mover  = new HanoiMover () ;
        Function<HanoiTowers, Function<String, HanoiTowers>> m = h -> c -> mover.move (c,h) ;
        // Function 'm', HanoiTowers <-- m (command, HanoiTowers)
        // Two arguments.

        Function<HanoiTowers, HanoiTowers> bc = h -> m.apply (h).apply ("B->C") ;

        HanoiTowers ht1   = new HanoiTowers (4, 'B') ;
        System.out.printf ("Let's start with this Hanoi Tower:%n%s%n", ht1) ;

        String strCommand = "B->A" ;
        HanoiTowers ht2 = m.apply (ht1).apply (strCommand) ;
        System.out.printf ("String command:%s%nResult:%n%s%n", strCommand, ht2) ;

        HanoiTowers ht3 = bc.apply (ht2) ;
        // Function 'bc', HanoiTowers <-- bc (HanoiTowers).
        // One argument. (like all her sisters, 'ab', 'ac', etc).
        System.out.printf ("'bc' function applied%nResult:%n%s%n", ht3) ;

        // Another (preferred) way to define is:
        UnaryOperator<HanoiTowers> ac = h -> m.apply (h).apply ("A->C") ;
        HanoiTowers ht4 = ac.apply (ht3) ;
        System.out.printf ("'ac' function applied%nResult:%n%s%n", ht4) ;

        // Of course you can define all of them: ab, ac, ba, bc, ca, cb.

    }

}
