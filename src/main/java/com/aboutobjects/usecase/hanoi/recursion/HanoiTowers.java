package com.aboutobjects.usecase.hanoi.recursion;

import java.util.ArrayList;
import java.util.List;

public class HanoiTowers {

    private static final int STATUS_OK  = 0 ;
    private static final int STATUS_BAD = 1 ;

    private int status ;

    public boolean validStatus      ()   {   return status == STATUS_OK  ;}
    public boolean invalidStatus    ()   {   return ! validStatus(); }

    private List<Integer> stackA ;
    private List<Integer> stackB ;
    private List<Integer> stackC ;

    private String lastBadMove ;

    public HanoiTowers (int nDisks, char whichInitialTower) {

        status = STATUS_OK ;

        stackA = new ArrayList<>() ;
        stackB = new ArrayList<>() ;
        stackC = new ArrayList<>() ;

        List<Integer> destinationList = stackA ;
        if ( whichInitialTower ==  'A' ) destinationList = stackA ;
        if ( whichInitialTower ==  'B' ) destinationList = stackB ;
        if ( whichInitialTower ==  'C' ) destinationList = stackC ;

        if (nDisks < 1 ) nDisks =  1 ;
        if (nDisks > 20) nDisks = 20 ;

        for (int i = 1; i <= nDisks; i++)
            destinationList.add (nDisks-i+1) ;

        lastBadMove = "" ;

    }

    public void move (String indicator) {

        if (invalidStatus()) {
            lastBadMove = indicator + ": attempt to make a move (any move) after reaching invalid status." ;
            return ;
        }

        List<Integer> fromTower = getFromTower (indicator) ;
        List<Integer> toTower   = getToTower   (indicator) ;

        if (fromTower.isEmpty()) {
            status = STATUS_BAD ;
            lastBadMove = indicator + ": attempt to move from an empty tower !" ;
            return ;
        }
        Integer topFrom = fromTower.get(fromTower.size()-1) ;
        if (!toTower.isEmpty()) {
            Integer topTo = toTower.get(toTower.size() - 1);
            if (topFrom > topTo) {
                status = STATUS_BAD;
                lastBadMove = indicator + ": attempt to move to a smaller disk !" ;
                return;
            }
        }
        toTower.add(topFrom) ;
        fromTower.remove(fromTower.size()-1) ;

    }

    // Could these two be rewritten functionally as getTower(indicator, String::startsWith), and getTower(indicator, String::endsWith). ?
    private List<Integer> getFromTower (String indicator) {

        if (indicator == null || indicator.isEmpty())   return stackA ;

        if (indicator.startsWith("A"))  return stackA ;
        if (indicator.startsWith("B"))  return stackB ;
        if (indicator.startsWith("C"))  return stackC ;

        return stackA ;

    }
    private List<Integer> getToTower (String indicator) {

        if (indicator == null || indicator.isEmpty())   return stackA ;

        if (indicator.endsWith("A"))  return stackA ;
        if (indicator.endsWith("B"))  return stackB ;
        if (indicator.endsWith("C"))  return stackC ;

        return stackA ;

    }

    public HanoiTowers copy () {

        HanoiTowers result = new HanoiTowers(1, 'A');
        result.status = this.status;
        result.lastBadMove = this.lastBadMove ;
        result.stackA = new ArrayList<>() ;
        result.stackB = new ArrayList<>() ;
        result.stackC = new ArrayList<>() ;

        result.stackA.addAll (this.stackA) ;
        result.stackB.addAll (this.stackB) ;
        result.stackC.addAll (this.stackC) ;

        return result ;

    }

    public Integer topTowerA () {
        if (stackA.isEmpty())   return null;
        return stackA.get(stackA.size()-1) ;
    }
    public Integer topTowerB () {
        if (stackB.isEmpty())   return null;
        return stackB.get(stackB.size()-1) ;
    }
    public Integer topTowerC () {
        if (stackC.isEmpty())   return null;
        return stackC.get(stackC.size()-1) ;
    }

    public int sizeOfTowerA () {    return stackA.size() ; }
    public int sizeOfTowerB () {    return stackB.size() ; }
    public int sizeOfTowerC () {    return stackC.size() ; }

    public boolean towerAisEmpty () {   return stackA.isEmpty() ; }
    public boolean towerBisEmpty () {   return stackB.isEmpty() ; }
    public boolean towerCisEmpty () {   return stackC.isEmpty() ; }

    public String toString () {

        String flechita = "--->" ;
        if (invalidStatus())
            flechita += "badStatus. " + lastBadMove +  "--->" ;

        StringBuilder sb = new StringBuilder (100);

        sb.append ("towerA") ;
        sb.append (flechita) ;
        stackA.stream().forEach(i -> sb.append (String.format("|%d",i)) );
        sb.append ("\n") ;

        sb.append ("towerB") ;
        sb.append (flechita) ;
        stackB.stream().forEach(i -> sb.append (String.format("|%d",i)) );
        sb.append ("\n") ;

        sb.append ("towerC") ;
        sb.append (flechita) ;
        stackC.stream().forEach(i -> sb.append (String.format("|%d",i)) );
        sb.append ("\n") ;

        return sb.toString() ;

    }

}
