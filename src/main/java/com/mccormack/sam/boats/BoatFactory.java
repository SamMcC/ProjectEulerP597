package com.mccormack.sam.boats;

public class BoatFactory {
    public Boat getBoat(int id) {
        return new Boat(id);
    }
}
