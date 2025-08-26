package Chapter_2_2;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<GroceryListItem> groceryList = new ArrayList();

    public GroceryListManager() {}

    // This method should add the given item to the grocery list.
    public void addItem(String item, double cost, String category, int quantity) {
        if (checkItem(item)) {
            System.err.println("Error: item " + item + " already added.");
            return;
        }
        groceryList.add(new GroceryListItem(item, category, cost, quantity));
    }

    // This method should remove the given item from the grocery list.
    public void removeItem(String item) {
        if (!checkItem(item)) {
            System.err.println("Error: item " + item + " is non-existent.");
            return;
        }

        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).name == item) {
                groceryList.remove(i);
                return;
            }
        }
    }

    public void updateQuantity(String name, int newQuantity) {
        for (GroceryListItem item : groceryList) {
            if (item.name == name) {
                item.quantity = newQuantity;
            }
        }
    }

    // This method should display all the items in the grocery list.
    public void displayList() {
        int counter = 1;
        for (GroceryListItem item : groceryList) {
            System.out.println(counter + ". " + item.name);
            counter++;
        }
    }

    public void displayByCategory(String category) {
        int counter = 1;
        for (GroceryListItem item : groceryList) {
            if (item.category == category) {
                System.out.println(counter + ". " + item.name + " (" + item.category + ")");
                counter++;
            }
        }
    }

    public void displayAvailableItems() {
        int counter = 1;
        for (GroceryListItem item : groceryList) {
            if (item.quantity > 0) {
                System.out.println(counter + ". " + item.name + " (" + item.quantity + ")");
                counter++;
            }
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (GroceryListItem item : groceryList) {
            if (item.quantity > 0) {
                totalCost += item.cost * item.quantity;
            }
        }
        return totalCost;
    }

    // This method should check if the given item is present in the grocery list and return a boolean value.
    public boolean checkItem(String item) {
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).name == item) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 10, "Fruits", 12);
        manager.addItem("Milk", 20, "Dairy", 24);
        manager.addItem("Bread", 30, "Bakery", 36);

        System.out.println("Grocery List:");
        manager.displayList();

        boolean milkIsPresent = manager.checkItem("Milk");
        System.out.println("Is \"Milk\" in the grocery list? " + milkIsPresent);

        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println("Updated Grocery List:");
        manager.displayList();

        System.out.println("Filter by Fruits:");
        manager.displayByCategory("Fruits");

        System.out.println("Filter by items with positive quantity:");
        manager.displayAvailableItems();

        System.out.println("Updating amount of apples to 100:");
        manager.updateQuantity("Apples", 100);
        manager.displayAvailableItems();

        // Error checks
        manager.addItem("Apples", 20, "Fruits", 48); // duplicate
        manager.removeItem("Tomatoes"); // not existent

        System.out.println("Apples quantity is negative, so not listed as available:");
        manager.updateQuantity("Apples", -10);
        manager.displayAvailableItems();

        System.out.println("Total cost: " + manager.calculateTotalCost());
    }
}
