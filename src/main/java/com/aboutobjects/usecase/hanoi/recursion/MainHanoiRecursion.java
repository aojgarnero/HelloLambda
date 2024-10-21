package com.aboutobjects.usecase.hanoi.recursion;

import java.util.ArrayList;
import java.util.List;

public class MainHanoiRecursion {

    public static void main (String flag) {

        int nDisks = 7 ;

        //----------- get the comands/moves to send 'nDisks' from A to C.
        List<String> hanoiCommands ;
        if ("gemini".equals(flag)) {
            hanoiCommands = GeminiHanoiCommandsByRecursion.solve(nDisks, "A", "C", "B");
        } else {
            hanoiCommands = new ArrayList<>();
            HanoiCommandsByRecursion.generate(nDisks, 'A', 'C', hanoiCommands);
        }

        //----------- Construct a HanoiTowers.
        HanoiTowers ht = new HanoiTowers (nDisks, 'A') ;

        //----------- apply the commands.
        System.out.println ("=== Start ===");
        System.out.println (ht) ;
        //----------- move.
        hanoiCommands.stream().forEach(s -> {
          ht.move (s) ;
          System.out.println (s)  ;
          System.out.println (ht) ;
        });

    }

}
