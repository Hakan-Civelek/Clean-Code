package ch02.elevator;

import ch02.elevator.domain.EncapsulatedElevator;
import ch02.elevator.domain.Floor;

public class EncapsulatedElevatorTest {
    public static void main(String[] args) {
        EncapsulatedElevator encapElevator = new EncapsulatedElevator();

        encapElevator.openDoor();
        encapElevator.goDown();
        encapElevator.goUp();
        encapElevator.goUp();
        encapElevator.closeDoor();
        encapElevator.openDoor(); // Somebody is coming :)
        encapElevator.goDown();
        encapElevator.goDown();
        encapElevator.goDown();
        encapElevator.go(Floor.FOURTH);
        encapElevator.goUp();
        encapElevator.goUp();
    }
}
