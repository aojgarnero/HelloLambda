package com.aboutobjects.usecase.hanoi.currying;

import com.aboutobjects.usecase.hanoi.recursion.HanoiTowers;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HanoiTowersCurryingTest {

    @Test
    void fromTwoToOneArgument () {

        HanoiMover mover  = new HanoiMover () ;
        Function<HanoiTowers, Function<String, HanoiTowers>> m = h -> c -> mover.move (c,h) ;
        Function<HanoiTowers, HanoiTowers> ab = h -> m.apply (h).apply ("A->B") ;

        HanoiTowers h1 = new HanoiTowers (3, 'A') ;
        HanoiTowers h2 = ab.apply (h1) ;

        System.out.println ("-----------------");
        System.out.println (h2);

        assertEquals (2, h2.sizeOfTowerA ()) ;
        assertEquals (1, h2.sizeOfTowerB ()) ;
        assert (h2.towerCisEmpty());
        assertEquals (2, h2.topTowerA    ()) ;
        assertEquals (1, h2.topTowerB    ()) ;
        assert (h2.validStatus ()) ;

    }

}
