package com.aboutobjects.usecase.hanoi.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HanoiTowersTest {

    @Test
    void basicMovesTest () {

        System.out.printf ("----------------------------------------------------%n") ;
        HanoiTowers hanoiTowers = new HanoiTowers (7, 'A') ;
        System.out.printf ("%s%n", hanoiTowers.toString()) ;
        assert (hanoiTowers.towerBisEmpty());
        assert (hanoiTowers.towerCisEmpty());
        assert (hanoiTowers.validStatus()) ;
        assertEquals (7, hanoiTowers.sizeOfTowerA ()) ;
        assertEquals (1, hanoiTowers.topTowerA    ()) ;

        System.out.printf ("--------Command:%s%n", "A->B") ;
        hanoiTowers.move ("A->B") ;
        System.out.printf ("%s%n", hanoiTowers.toString()) ;
        assertEquals (6, hanoiTowers.sizeOfTowerA ()) ;
        assertEquals (1, hanoiTowers.sizeOfTowerB ()) ;
        assert (hanoiTowers.towerCisEmpty());
        assertEquals (2, hanoiTowers.topTowerA    ()) ;
        assertEquals (1, hanoiTowers.topTowerB    ()) ;
        assert (hanoiTowers.validStatus ()) ;

        System.out.printf ("--------Command:%s%n", "A->C") ;
        hanoiTowers.move("A->C");
        System.out.printf ("%s%n", hanoiTowers.toString()) ;
        assert (hanoiTowers.validStatus ()) ;

        System.out.printf ("--------Command:%s, again. (is not a valid move!)%n", "A->B") ;
        hanoiTowers.move("A->B");
        System.out.printf ("%s%n", hanoiTowers.toString()) ;
        assert (hanoiTowers.invalidStatus ()) ;

    }

    @Test
    void recursiveGenerateTest () {

        //----------- 1 comamnd.
        List<String> aToC1 = new ArrayList<>();
        HanoiCommandsByRecursion.generate (1, 'A', 'C', aToC1) ;
        assert ( ! aToC1.isEmpty ()) ;
        assertEquals (1, aToC1.size ()) ;
        assertEquals ("A->C", aToC1.get (0)) ;

        //----------- 'generate' is recursive, isn't it.
        List<String> aToB3 = new ArrayList<>();
        HanoiCommandsByRecursion.generate (3, 'A', 'B', aToB3) ;

        List<String> bToC3 = new ArrayList<>();
        HanoiCommandsByRecursion.generate (3, 'B', 'C', bToC3) ;

        List<String> expected = new ArrayList<>();
        expected.addAll (aToB3) ;
        expected.addAll (aToC1) ;
        expected.addAll (bToC3) ;

        List<String> aToC4 = new ArrayList<>();
        HanoiCommandsByRecursion.generate (4, 'A', 'C', aToC4) ;
        assertEquals (expected, aToC4) ;
        // to move 4 disks from A->C is to:
        //      move 3 disks from A->B
        //      move 1 disk  from A->C
        //      move 3 disks from B->C
        //      Isn't it.

    }

}
