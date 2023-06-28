import java.util.LinkedList;
import java.util.Queue;

public class DockManager {
    private boolean[] doorAvailability;
    private Queue<Truck> waitingQueue;

    public DockManager(int numDoors) {
        doorAvailability = new boolean[numDoors];
        waitingQueue = new LinkedList<>();
    }

    public void assignDoor(Truck truck) {
        int assignedDoor = findAvailableDoor();

        if (assignedDoor != -1) {
            markDoorAsBusy(assignedDoor);
            System.out.println("Truck " + truck.getId() + " assigned to door " + assignedDoor);
            Box box = new Box(10, "medium", 5); // Create a Box object
            truck.unload(box); // Pass the Box object as an argument to the unload method
        } else {
            waitingQueue.offer(truck);
            System.out.println("Truck " + truck.getId() + " added to waiting queue");
        }
    }

    private int findAvailableDoor() {
        for (int door = 0; door < doorAvailability.length; door++) {
            if (!doorAvailability[door]) {
                return door;
            }
        }
        return -1; // No available doors
    }

    public void doorBecomesAvailable(int door) {
        if (!waitingQueue.isEmpty()) {
            Truck truck = waitingQueue.poll();
            markDoorAsBusy(door);
            System.out.println("Truck " + truck.getId() + " assigned to door " + door);
            Box box = new Box(4, "small", 3);
            truck.unload(box); // Proceed with unloading the truck
        } else {
            markDoorAsAvailable(door);
            System.out.println("Door " + door + " is now available");
        }
    }

    private void markDoorAsBusy(int door) {
        doorAvailability[door] = true;
    }

    private void markDoorAsAvailable(int door) {
        doorAvailability[door] = false;
    }

    // Other helper methods and getter/setter methods

    // Additional methods relevant to dock management
}
