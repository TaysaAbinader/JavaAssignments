package Chapter_2_2;

import java.util.HashMap;
import java.util.Set;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public GroceryListManager() {}

    // This method should add the given item to the grocery list.
    public void addItem(String item, double cost) {
        if (checkItem(item)) {
            System.err.println("Error: item " + item + " already added.");
            return;
        }
        groceryList.put(item, cost);
    }

    // This method should remove the given item from the grocery list.
    public void removeItem(String item) {
        if (!checkItem(item)) {
            System.err.println("Error: item " + item + " is non-existent.");
            return;
        }
        groceryList.remove(item);
    }

    // This method should display all the items in the grocery list.
    public void displayList() {
        int counter = 1;
        for (String item : groceryList.keySet()) {
            System.out.println(counter + ". " + item);
            counter++;
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }

    // This method should check if the given item is present in the grocery list and return a boolean value.
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 10);
        manager.addItem("Milk", 20);
        manager.addItem("Bread", 30);

        System.out.println("Grocery List:");
        manager.displayList();

        boolean milkIsPresent = manager.checkItem("Milk");
        System.out.println("Is \"Milk\" in the grocery list? " + milkIsPresent);

        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println("Updated Grocery List:");
        manager.displayList();

        // Error checks
        manager.addItem("Apples", 20); // duplicate
        manager.removeItem("Tomatoes"); // not existent

        System.out.println("Total cost: " + manager.calculateTotalCost());
    }
}
