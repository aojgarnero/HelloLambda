package com.aboutobjects;

import com.aboutobjects.immutable.conversation.LambdletSoliloquyOnImmutableInteger;
import com.aboutobjects.usecase.hanoi.currying.MainHanoiCurrying;
import com.aboutobjects.usecase.hanoi.recursion.MainHanoiRecursion;
import com.aboutobjects.usecase.one.MainUseCaseOne;
import com.aboutobjects.usecase.primes.MainPrimes;

public class App  {

    public static void main (String [] args) {

        System.out.println ("Hello Lambda") ;

        int what = 1 ;
        if (what == 1) MainUseCaseOne.main ("else") ;
        if (what == 2) MainPrimes.main ("lambda") ;
        if (what == 3) LambdletSoliloquyOnImmutableInteger.main();
        if (what == 4) MainHanoiRecursion.main () ;
        if (what == 5) MainHanoiCurrying.main () ;

    }


}
