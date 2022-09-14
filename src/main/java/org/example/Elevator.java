package org.example;

import java.util.Arrays;

public class Elevator {

    private int[] elevator;

    private String direction;

    private int currentFloor;


    public Elevator() {
        this.elevator = new int[5];
        this.direction = "^";
        this.currentFloor = 1;
    }

    public int[] getElevator() {
        return elevator;
    }

    public void setElevator(int[] elevator) {
        this.elevator = elevator;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public String toString() {
        return "\nElevator{" +
                "passengers=" + Arrays.toString(elevator) +
                ", direction='" + direction + '\'' +
                ", currentFloor=" + currentFloor +
                '}' + " goTo=" + goTo() + "\n";
    }

    public int getPassengerNumber() {
       return (int) Arrays.stream(this.elevator).filter(p -> p > 0).count();
    }

    public void entrancePassenger(int wantFloor) {
        for (int i = 0; i < 5; i++) {
            if (elevator[i] == 0) {
                elevator[i] = wantFloor;
                break;
            }
        }
    }

    public void exitPassenger(int i) {
        this.elevator[i] = 0;
    }

    public int goTo() {
        var passenger = Arrays.stream(this.elevator).filter(p -> p > 0).findFirst();
        int goTo = passenger.isPresent() ? passenger.getAsInt() : 0;

        if (this.getPassengerNumber() >= 1 ) {
            if (this.getDirection().equals("^")) {
                var min = Arrays.stream(this.elevator)
                        .filter(p -> p > this.getCurrentFloor()).min();
                goTo = min.isPresent() ? min.getAsInt() : Arrays.stream(elevator).findAny().getAsInt();
            }

            if (this.getDirection().equals("V")) {
                var max = Arrays.stream(this.elevator)
                        .filter(p -> p > 0 && p < this.getCurrentFloor()).max();
                goTo = max.isPresent() ? max.getAsInt() : Arrays.stream(elevator).findAny().getAsInt();
            }

        } else goTo = this.currentFloor;

    return goTo;
    }

    public boolean isEmpty() {
       return Arrays.stream(this.elevator).sum() == 0;
    }
}
