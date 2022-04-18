package inventory_system;

import java.util.ArrayList;

/**
 * A representation of an inventory of items. Can be used to represent:
 * <p>
 * <ul>
 *      <li> A player, who, in playing the game, will aquire and sell items.
 * 
 *      <li> A shop that can sell items to and buy items from a player's own
 *           inventory.
 * </ul>
 * </p>
 * The items in inventories are made with an {@code ArrayList} of {@code Item} objects. The 
 * Item class works in conjunction with the Inventory class to represent items in the game by having
 * a name, a quantity, and a price.
 * 
 * @author Paul Brouillette
 * @version April 17, 2022
 * @see Item
 */
public class Inventory {
    private ArrayList<Item> items;

    /**
     * Constructor for Inventory. Initializes the ArrayList of Item objects.
     */
    public Inventory() {
        items = new ArrayList<Item>();
        items.add(new Item("Money", 150, 0));
    }

    /**
     * This checks if the item is already in the inventory. If it is, it will return
     * true, but if it is not, is will return false.
     * 
     * @param nameToMatch The name of the item to check for.
     * @return True if the item is in the inventory, false if it is not.
     */
    public boolean alreadyHasItem(String nameToMatch) {
        for (Item item : items) {
            if (item.getName().equals(nameToMatch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This adds an item to the inventory. If the item is already in the inventory,
     * it will add the quantity of the item to the existing item. If the item is not
     * in the inventory, it will add the item to the inventory.
     * 
     * <p>
     * Note: NEVER add money to the inventory using this method, the amount of money
     * will not be added correctly. Use the {@code addFunds(int amount)} method
     * instead.
     * </p>
     * 
     * @param item The item (or the quantity of that item) to add to the inventory.
     * @see #addFunds(int amount)
     */
    public void addItem(Item item) {
        if (alreadyHasItem(item.getName())) {
            for (Item i : items) {
                if (i.getName().equals(item.getName())) {
                    i.setQuantity(i.getQuantity() + 1);
                }
            }
        } else {
            items.add(item);
        }
    }

    /**
     * Special method that only deals with money. Simply adds the amount of money
     * to the already existing money Item. (Money should already be in the inventory
     * as initialized in the Game.java).
     * 
     * @param amount The amount of money to add to the inventory.
     */
    public void addFunds(int amount) {
        for (Item i : items) {
            if (i.getName().equals("Money")) {
                i.setQuantity(i.getQuantity() + amount);
            }
        }
    }

    /**
     * Returns the amount of money in the inventory.
     * 
     * @return The amount of money in the inventory.
     */
    public double getFunds() {
        for (Item i : items) {
            if (i.getName().equals("Money")) {
                return i.getQuantity();
            }
        }
        return 0;
    }

    /**
     * A simple toString method that returns the items in the inventory.
     * 
     * @return A string representation of the items in the inventory.
     */
    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Inventory is empty.";
        }

        String s = "";
        for (Item i : items) {
            if (i.getName().equals("Money")) {
                s += i.getName() + ": $" + i.getQuantity() + "\n";
            } else {
                s += i.getName() + ": " + i.getQuantity() + " ($" + i.getSellPrice() + " each)\n";
            }
        }
        return s;
    }

    /**
     * Removes a certain amount of an item from the inventory. If too much quantity
     * is removed, the entire item will be removed as a result.
     * 
     * @param name   The name of the item to remove from.
     * @param amount The quantity of that item to remove.
     */
    public void removeItem(String name, int amount) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(name)) {
                i.setQuantity(i.getQuantity() - amount);
                if (i.getQuantity() <= 0) {
                    items.remove(i);
                }
                break;
            }
        }
    }

    /**
     * Returns the inventory as opposed to having to call Game.inventory.
     * 
     * @return The inventory ArrayList.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Returns a specific item from the inventory.
     * 
     * @param selectedIndex The index of the item to return.
     * @return The item at the selected index.
     */
    public Item getItem(int selectedIndex) {
        return items.get(selectedIndex);
    }

    /**
     * This method will return the total value of the items in the inventory.
     * 
     * @return The size of the inventory.
     */
    public int getSize() {
        return items.size();
    }
}