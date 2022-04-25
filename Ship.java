import java.awt.Image;

public class Ship {  

    String name;
    String description;
    Boolean playerOwned;
    int health;
    int cargoCapacity;
    int cargoSpaceUsed;
    int attackPower;
    Image shipImage;

    /**
     * Constructor for ship.
     * 
     * @param name The name of the ship.
     * @param description The description of the ship.
     * @param playerOwned Whether or not the ship is playerOwned.
     * @param health The health of the ship.
     * @param cargoCapacity The cargo capacity of the ship.
     * @param cargoSpaceUsed The amount of cargo space used by the ship.
     * @param attackPower The attack power of the ship.
     * @param shipImage The image of the ship.
     */
    public Ship(String name, String description, Boolean playerOwned, int health, int cargoCapacity, int attackPower, Image shipImage) {
        this.name = name;
        this.description = description;
        this.playerOwned = playerOwned;
        this.health = health;
        this.cargoCapacity = cargoCapacity;
        this.attackPower = attackPower;
        this.shipImage = shipImage;
    }

    /**
     * toString method for displaying the name, description, cargo capacity, health, and attack power.
     * 
     * @return The name, description, cargo capacity, health, and attack power.
     */
    @Override
    public String toString() {
        return name + ": " + description + " Cargo Capacity: " + cargoCapacity + " Health: " + health + " Attack Power: " + attackPower;
    }

    /**
     * This method returns the name of the ship.
     * 
     * @return The name of the ship.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the description of the ship.
     * 
     * @return The description of the ship.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method returns whether or not the ship is player owned.
     * 
     * @return Whether or not the ship is player owned.
     */
    public Boolean getplayerOwned() {
        return playerOwned;
    }

    /**
     * This method returns the health of the ship.
     * 
     * @return The health of the ship.
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method returns the cargo capacity of the ship.
     * 
     * @return The cargo capacity of the ship.
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }
    
    /**
     * This method returns the amount of cargo space used by the ship.
     * 
     * @return The amount of cargo space used by the ship.
     */
    public int getCargoSpaceUsed() {
        return cargoSpaceUsed;
    }
    
   /**
     * This method gets the location of the .png file for the ship in the
     * assets/ships folder to assist with displaying the ship on the UI.
     * 
     * @return The location of the .png file for the ship in the assets/ships folder.
     */
    public String getShipPicture() {
        return "assets/ship/" + name + ".png";
    }

    /**
     * Returns the Image of the current ship that can immediately be used
     * to display the ship on the UI as it is an Image.
     * 
     * @return The {@code Image} of the current ship.
     */
    public Image getShipImage() {
        return shipImage;
    }
}

