package org.example;

import java.util.HashMap;

public class ShoppingCart {
    HashMap<String, Double> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(String item, double value) {
        items.put(item, value);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
