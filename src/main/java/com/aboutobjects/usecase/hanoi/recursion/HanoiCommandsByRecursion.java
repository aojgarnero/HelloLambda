package com.aboutobjects.usecase.hanoi.recursion;

import java.util.List;

public class HanoiCommandsByRecursion {

    public static void generate (int n, char from, char to, List<String> stack) {

        if (n <= 0) return ;

        char otherTower = getOtherTower (from, to) ;

        generate (n - 1, from, otherTower, stack);
        stack.add (String.format ("%c->%c", from, to)) ;
        generate (n - 1, otherTower, to, stack);

    }

    private static char getOtherTower(char from, char to) {
        if (from == 'A' && to == 'B') return 'C' ;
        if (from == 'A' && to == 'C') return 'B' ;
        if (from == 'B' && to == 'A') return 'C' ;
        if (from == 'B' && to == 'C') return 'A' ;
        if (from == 'C' && to == 'A') return 'B' ;
        if (from == 'C' && to == 'B') return 'A' ;

        return 'X' ;
    }


}
