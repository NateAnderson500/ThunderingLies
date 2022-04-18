import java.util.Scanner;

/**
 * File that holds the array that contains the entire Arcadian System
 * 
 * Author: Nate Anderson
 * Version: Alpha Build 0.1
 */

// creates main method
public class ArcadianSys {
    // creates 2d array with the planets from the planet class
    public static Planet[][] Arcadian = new Planet[16][5];
    // creates scanner
    public static Scanner input = new Scanner(System.in);
    // creates a variable for the current planet
    public static Planet currentPlanet;

    // constructor for the arcadian system
    public ArcadianSys() {
        // sets the current planet to be new terra in the array
        currentPlanet = Arcadian[0][2];
        // calls the method that creates the arcadian system
        createArcadian();
    }

    // method that creates the arcadian system
    public static void createArcadian() {
        // sets the name of the planet to be Corvus
        Arcadian[0][0] = new Planet("Corvus", "Closest planet to the sun", new String[] { "Thantos" }, false);

        // sets the name of the planet to be Thantos
        Arcadian[0][1] = new Planet("Thantos", "Micro planet", new String[] { "Corvus", "New Terra" }, false);

        // sets the name of the planet to be New Terra
        Arcadian[0][2] = new Planet("New Terra", "Earthlike", new String[] { "Thantos", "Ligo" }, true);

        // sets the name of the planet to be Ligo
        Arcadian[0][3] = new Planet("Ligo", "Colder verison of New Terra", new String[] { "New Terra", "Labrynith" },
                false);

        // sets the name of the planet to be Labrynith
        Arcadian[0][4] = new Planet("Labrynith", "Rocky and Barren", new String[] { "Ligo", "Keres" }, false);

        // sets the name of the planet to be Keres
        Arcadian[0][5] = new Planet("Keres", "Similar to Mars IRL", new String[] { "Labrynith", "Aesop" }, false);

        // sets the name of the planet to be Aesop
        Arcadian[0][6] = new Planet("Aesop", "Second micro planet", new String[] { "Keres", "Unicas" }, false);

        // sets the name of the planet to be Unicas
        Arcadian[0][7] = new Planet("Unicas", "Ringed gas planet", new String[] { "Aesop", "Abenaki" }, false);

        // sets the name of the planet to be Abenaki
        Arcadian[0][8] = new Planet("Abenaki", "Volcanic", new String[] { "Unicas", "Pollux" }, false);

        // sets the name of the planet to be Pollux
        Arcadian[0][9] = new Planet("Pollux", "Icy Planet", new String[] { "Abenaki", "Boreas"}, false);

        // sets the name of the planet to be Boreas
        Arcadian[0][9] = new Planet("Boreas", "Icy Planet", new String[] { "Pollux", "Macintyre" }, false);

        // sets the name of the planet to be Macintyre
        Arcadian[0][10] = new Planet("Macintyre", "Ball of Ice", new String[] { "Boreas", "Vanu" }, false);

        // sets the name of the planet to be Vanu
        Arcadian[0][11] = new Planet("Vanu", "Purple Ice", new String[] { "Macintyre", "Gandash" }, false);

        // sets the name of the planet to be Gandash
        Arcadian[0][12] = new Planet("Gandash", "Gas Giant with metal rings", new String[] { "Vanu", "Artemisia" }, false);

        // sets the name of the planet to be Artemisia
        Arcadian[0][13] = new Planet("Artemisia", "Uninhabited", new String[] { "Gandash" }, false);
    }

    // creates main method
    public static void main(String[] args) {

    }
}