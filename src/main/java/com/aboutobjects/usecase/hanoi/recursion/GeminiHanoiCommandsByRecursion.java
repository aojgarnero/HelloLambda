package com.aboutobjects.usecase.hanoi.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeminiHanoiCommandsByRecursion {

    public static List<String> solve (int n, String source, String target, String auxiliary) {

        List<String> moves = new ArrayList<>();

        if (n == 1) {
            moves.add(source + "->" + target);
        } else {
            moves.addAll(solve(n - 1, source, auxiliary, target));
            moves.add(source + "->" + target);
            moves.addAll(solve(n - 1, auxiliary, target, source));
        }
        return moves;
    }


}
