package com.mccormack.sam.conditions;

import com.mccormack.sam.boats.Boat;

import java.util.List;

public class Permutation {
    private List<Boat> startingOrder;
    private List<Boat> finishingOrder;

    public Permutation(List<Boat> startingOrder, List<Boat> finishingOrder) {
        this.finishingOrder = finishingOrder;
        this.startingOrder = startingOrder;
    }

    public List<Boat> getStartingOrder() {
        return startingOrder;
    }

    public List<Boat> getFinishingOrder() {
        return finishingOrder;
    }

    public boolean isEvenPermutation() {
        int nChanges = 0;
        for (Boat boat : startingOrder) {
            if (finishingOrder.indexOf(boat) != startingOrder.indexOf(boat)) {
                nChanges += 1;
            }
        }

        return nChanges % 2 == 0;
    }
}
