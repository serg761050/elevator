package org.example;

import java.util.ArrayList;

public class Floor {

    private final ArrayList<Integer> floor;

    private final int floorNumber;

    public Floor(int number) {
        this.floor = new ArrayList<>();
        this.floorNumber = number;
    }

    @Override
    public String toString() {
        return  "passengers=" + floor +
                ", floorNumber=" + floorNumber;
    }

    public ArrayList<Integer> getFloorNumber(int floorNumber) {
        return floor;
    }

    public void entrancePassenger(int wantFloor) {
        this.floor.add(wantFloor);
    }

    public void exitPassenger(int i){
        this.floor.remove(i);
    }

    public int size() {
        return floor.size();
    }

}
