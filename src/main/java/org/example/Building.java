package org.example;

import java.util.Arrays;

public class Building {

    private final Floor[] building;



    public Building(int floorNumber) {
        this.building = new Floor[floorNumber];
        for (int i = 0; i < floorNumber; i++) {
            Floor floor = new Floor(i + 1);
            building[i] = floor;
        }
    }

    public Floor[] getFloors() {
        return building;
    }


    @Override
    public String toString() {
        return Arrays.toString(building);
        }


}
