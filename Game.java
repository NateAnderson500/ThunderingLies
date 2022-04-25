import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import inventory_system.Inventory;
import inventory_system.Item;
import planetary_system.ArcadianSystem;
import planetary_system.Planet;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The main file where everything for the game is called and managed here. 
 */
public class Game implements Runnable {
    public static UserInterface ui;
    public static ArcadianSystem arcadianSystem;
    public static Planet currentPlanet;
    public static Inventory inventory = new Inventory();
    public static Ship currentShip;
    public static saveGameData saveGame;
    Scanner sc;
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Game());
    }
    
    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //Create the image for the ship to be passed in as a parameter
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File("assets/ships/regularship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = bi.getScaledInstance(350, 350, Image.SCALE_SMOOTH);

        File text = new File("savegame.txt");
        try {
            sc = new Scanner(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String planetString = sc.nextLine();

        currentShip = new Ship("Le Ship", "This is le ship hehe", true, 2100, 100, 69, image);
        inventory.addItem(new Item("Wrench", 1, 45));
        arcadianSystem = new ArcadianSystem();
        currentPlanet = arcadianSystem.getPlanet(planetString);
        saveGame = new saveGameData();
        ui = new UserInterface();
        ui.run();
    }
}
