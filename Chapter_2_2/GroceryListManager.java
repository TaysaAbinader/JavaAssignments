package Chapter_2_2;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public GroceryListManager() {}

    // This method should add the given item to the grocery list.
    public void addItem(String item) {
        if (checkItem(item)) {
            System.err.println("Error: item " + item + " already added.");
            return;
        }
        groceryList.add(item);
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
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    } 

    // This method should check if the given item is present in the grocery list and return a boolean value.
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        System.out.println("Grocery List:");
        manager.displayList();

        boolean milkIsPresent = manager.checkItem("Milk");
        System.out.println("Is \"Milk\" in the grocery list? " + milkIsPresent);

        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println("Updated Grocery List:");
        manager.displayList();

        // Error checks
        manager.addItem("Apples"); // duplicate
        manager.removeItem("Tomatoes"); // not existent
    }
}
