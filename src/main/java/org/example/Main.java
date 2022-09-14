package org.example;


public class Main {
    public static void main(String[] args) {

        int stepsForRepresent = 5;

        int buildingFloorNumber = 5 + (int)(Math.random()*((20 - 5) + 1));

        Building building = new Building(buildingFloorNumber);

        for (int i = 0; i < buildingFloorNumber; i++) {
            int passengerNumberOnFloor = 1 + (int) (Math.random() * ((10 - 1) + 1));
            for (int j = 0; j < passengerNumberOnFloor; j++) {
                int wantFloor = i+1;
                while (wantFloor == i+1) {
                    wantFloor = 1 + (int)(Math.random()*((buildingFloorNumber - 1) + 1));
                }
                building.getFloors()[i].entrancePassenger(wantFloor);
            }
        }

        Elevator elevator = new Elevator();

        printBuilding(building);
        System.out.println(elevator);

        Controller controller = new Controller(elevator, building);
        controller.start(building.getFloors()[0], 0);
        int goTo = elevator.goTo();

        System.out.println("------STEP 1 ------");
        printBuilding(building);
        System.out.println(elevator);

        for (int i = 2; i <= stepsForRepresent; i++) {
            controller.exit(goTo);
            controller.entrance(goTo);
            System.out.println("------STEP " + i + " ------");
            printBuilding(building);
            System.out.println(elevator);
            goTo = elevator.goTo();

            if (controller.revers(goTo) ) {
                controller.start(building.getFloors()[goTo-1], goTo-1);
            }

            if (elevator.isEmpty()) {
                elevator.setCurrentFloor(goTo);
                controller.start(building.getFloors()[goTo-1], goTo-1);
            }
            goTo = elevator.goTo();

        }
    }

    private static void printBuilding(Building building) {
        for (int i = building.getFloors().length - 1; i >= 0 ; i--) {
            System.out.println(building.getFloors()[i]);
        }
    }
}