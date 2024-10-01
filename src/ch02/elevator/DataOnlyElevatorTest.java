package ch02.elevator;

import ch02.elevator.domain.DataOnlyElevator;

public class DataOnlyElevatorTest {
    private static DataOnlyElevator publicElevator = new DataOnlyElevator();
    static boolean stopped = false;

    public static void main(String[] args) {
        printElevatorState();
        publicElevator.doorOpen = true;

        publicElevator.doorOpen = false;
        printElevatorState();

        publicElevator.currentFloor--;
        publicElevator.currentFloor++;

        publicElevator.currentFloor = 7;
        publicElevator.doorOpen = true;

        printElevatorState();
        publicElevator.doorOpen = false;

        publicElevator.currentFloor = -15;
        printElevatorState();
        publicElevator.doorOpen = true;
        publicElevator.currentFloor++;
        printElevatorState();
        publicElevator.doorOpen = false;
        publicElevator.currentFloor--;
        publicElevator.currentFloor--;
        printElevatorState();
        publicElevator.currentFloor--;
        printElevatorState();

        System.out.println("***********************");

        Thread thread = new Thread(){
            public void run(){
                System.out.println("Started!");
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                stopped = true;
                System.out.println("Stopped!");
            }
        };

        thread.start();

        while(!stopped){
            publicElevator.currentFloor--;
        }
        printElevatorState();
    }

    public static void printElevatorState(){
        String doorStatusString = "CLOSED";
        if(publicElevator.doorOpen)
            doorStatusString = "OPEN";

        System.out.println("Elevator is at floor " + publicElevator.currentFloor + " and the door is " + doorStatusString);
    }
}
