package com.mccormack.sam.boats;

public class Boat {
    private final int startingPosition;
    private final double speed;

    public Boat(int startingPosition) {
        this.startingPosition = startingPosition;
        this.speed = - Math.log(Math.random());
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    public double getSpeed() {
        return speed;
    }
}
