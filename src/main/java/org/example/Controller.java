package org.example;


public class Controller {

    private final Elevator elevator;

    private final Building building;


    public Controller(Elevator elevator, Building building) {
        this.elevator = elevator;
        this.building = building;
    }

    public void start(Floor floor, int floorNumber) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < floor.getFloorNumber(floorNumber).size(); j++) {
                elevator.entrancePassenger(floor.getFloorNumber(floorNumber).get(j));
                floor.exitPassenger(j);
                break;
            }
        }
    }

    public void exit(int floorNumber) {
        elevator.setCurrentFloor(floorNumber);
        for (int i = 0; i < 5; i++) {
            if (elevator.getElevator()[i] == floorNumber) {
                elevator.exitPassenger(i);

                int wantFloor = i + 1;
                while (wantFloor == i + 1) {
                    wantFloor = 1 + (int) (Math.random() * ((building.getFloors().length - 1) + 1));
                }
                building.getFloors()[floorNumber-1].entrancePassenger(wantFloor-1);
            }
        }

    }

    public void entrance(int floorNumber) {
        elevator.setCurrentFloor(floorNumber);
        int freeSeats = 5 - elevator.getPassengerNumber();
        if (freeSeats > 0) {
            for (int i = 0; i < freeSeats; i++) {
                if (elevator.getDirection().equals("^")) {
                    for (int j = 0; j < building.getFloors()[floorNumber - 1].size(); j++) {
                        if (building.getFloors()[floorNumber - 1].getFloorNumber(floorNumber).get(j)
                                > elevator.getCurrentFloor()) {
                            elevator.entrancePassenger(building.getFloors()[floorNumber - 1]
                                    .getFloorNumber(floorNumber).get(j));
                            building.getFloors()[floorNumber - 1].getFloorNumber(floorNumber - 1).remove(j);
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean revers(int goTo) {
        boolean revers = false;
        if (building.getFloors().length == goTo) {
            elevator.setDirection("v");
            revers = true;
        }
        if (building.getFloors().length == 0) {
            elevator.setDirection("^");
            revers = true;
        }
        return revers;
    }
}



