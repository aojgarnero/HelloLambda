package com.aboutobjects.usecase.hanoi.currying;

import com.aboutobjects.usecase.hanoi.recursion.HanoiTowers;

public class HanoiMover implements HanoiMoverInterface {

    @Override
    public HanoiTowers move (String operation, HanoiTowers operand) {

        HanoiTowers result = operand.copy();
        result.move (operation) ;

        return result;

    }

}