package Chapter_5_2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListManager {
    private List<String> managedArray;

    public ArrayListManager () {
        // Alternative option.
        //this.managedArray = Collections.synchronizedList(new ArrayList<>());
        this.managedArray = new ArrayList<>();
    }

    public synchronized void addElement (long threadId, String element) {
        System.out.printf("Thread %d is adding \"%s\" to the list...\n", threadId, element);
        if (managedArray.contains(element)) {
            System.err.println("Error: element " + element + " already on list.");
        }
        managedArray.add(element);
    }

    public synchronized void queryManagedArray (long threadId) {
        System.out.printf("Thread %d is querying the list: %d elements\n", threadId, managedArray.size());
    }

    public synchronized void removeElement (long threadId, String element) {
        System.out.printf("Thread %d is removing \"%s\" from the list...\n", threadId, element);
        if (!managedArray.contains(element)) {
            System.err.println("Error: element " + element + " not on the list.");
        }
        managedArray.remove(element);
    }
}


