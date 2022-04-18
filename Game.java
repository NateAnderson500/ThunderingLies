import inventory_system.Inventory;
import inventory_system.Item;
import planetary_system.ArcadianSystem;
import planetary_system.Planet;

/**
 * The main file where everything for the game is called and managed here. 
 */
public class Game implements Runnable {
    public static UserInterface ui;
    public static ArcadianSystem arcadianSystem;
    public static Planet currentPlanet;
    public static Inventory inventory = new Inventory();
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Game());
    }
    
    @Override
    public void run() {
        inventory.addItem(new Item("Wrench", 1, 45));
        arcadianSystem = new ArcadianSystem();
        currentPlanet = arcadianSystem.pollux;
        ui = new UserInterface();
        ui.run();
    }
}
