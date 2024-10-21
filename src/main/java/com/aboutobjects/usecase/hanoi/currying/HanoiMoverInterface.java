package com.aboutobjects.usecase.hanoi.currying;

import com.aboutobjects.usecase.hanoi.recursion.HanoiTowers;

@FunctionalInterface
interface HanoiMoverInterface {
    HanoiTowers move (String operation, HanoiTowers operand);
}