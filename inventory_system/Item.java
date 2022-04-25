package inventory_system;

/**
 * A representation of an item that exists in an {@code Inventory}. In an 
 * inventory, items exist in an {@code ArrayList} and have a name, quantity, and
 * a buy price. 
 * <p>
 * If an item is attempted to be added to the inventory, but said item already exists
 * in the inventory, the quantity of said item will be added to the existing item instead
 * of a new Item being made and stored.
 * </p> 
 * 
 * @author Paul Brouillette
 * @version April 17, 2022
 * @see Inventory
 */
public class Item {
    private String name;
    private int quantity;
    private double buyPrice, sellPrice;

    /**
     * Constructor for Item.
     * 
     * @param name The name of the item.
     * @param quantity The quantity of the item.
     * @param buyPrice The buy price of the item.
     * @param sellPrice The sell price of the item.
     */
    public  Item(String name, int quantity, double buyPrice) {
        this.name = name;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = buyPrice * .75;
    }

    /**
     * This method returns the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the quantity of the item.
     * 
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method returns the buy price of the item.
     * 
     * @return The buy price of the item.
     */
    public int getBuyPrice() {
        return (int)buyPrice;
    }

    /**
     * This method returns the sell price of the item.
     * 
     * @return The sell price of the item.
     */
    public int getSellPrice() {
        return (int)sellPrice;
    }

    /**
     * If a situation arises where an item is trying to be added to the inventory
     * but it already exists in the inventory, this method will add the quantity
     * of the item to the existing item (instead of creating a new Item).
     * 
     * @param quantity The quantity of the item to add.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
