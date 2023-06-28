import java.util.ArrayList;
import java.util.List;

public class Truck {
    private int id;
    private List<Box> boxes;

    public Truck(int id) {
        this.id = id;
        this.boxes = new ArrayList<>();
    }
    
    public int getId() { 	
    return id;
    }

    public void arrive() {
        System.out.println("Truck " + id + " has arrived.");
        // Add logic for truck arrival
        
        unloadBoxes();
        process();
        
    }
    
    private void unloadBoxes() {
        // Simulate the unloading of boxes from the truck
        int numOfBoxes = getRandomNumberOfBoxes(); // Get a random number of boxes to unload
        
        for (int i = 0; i < numOfBoxes; i++) {
            Box box = createRandomBox(i + 1); // Create a random box
            unload(box); // Unload the box from the truck
        }
    }
        
    private int getRandomNumberOfBoxes() {
            // Implement the logic to generate a random number of boxes to unload
            // You can use Java's random number generation methods or any other method you prefer
            return 5; // Replace with your random number generation logic
        }

    private Box createRandomBox(int boxId) {
    	
    	;
            // Implement the logic to create a random box
            // You can define the attributes of the box (e.g., size, weight) based on your simulation requirements
            // Return the created box object
            return new Box(boxId, "Medium", 10); // Replace with your random box generation logic
        }  

    public void unload(Box box) {
        boxes.add(box);
        System.out.println("Unloaded box " + box.getId() + " from truck " + id);
        // Add logic for unloading a box from the truck
    }

    public void process() {
        System.out.println("Processing truck " + id);
        // Add logic for processing the truck, e.g., moving it to the appropriate location or performing any necessary operations
    }

    // Add getter and setter methods for the attributes

    // Add any additional methods relevant to a truck
}

