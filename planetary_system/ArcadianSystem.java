package planetary_system;

public class ArcadianSystem {
   //2d array goes row (top to bottom), column (left to right)
    public Planet[][] planets;
    public Planet corvus, thantos, newTerra, ligo, 
        labyrinth, keres, aesop, uncas, abenaki, pollux, 
        boreas, macintyre, vanu, gandash, artemisia;

    /**
     * Constructor for ArcadianSystem. Makes every space in the array list either a space that represents
     * a place in space, or a planet.
     */ 
    public ArcadianSystem() {
        planets = new Planet[16][5];

        //Fill every index of planets with a planet named space
        for (int i = 0; i < planets.length; i++) {
            for (int j = 0; j < planets[i].length; j++) {
                planets[i][j] = new Planet("Space", "Nothing here, just space.", new String[]{}, false);
            }
        }

        corvus = new Planet("Corvus", "A blisteringly hot planet, it is closest to the sun.", new String[]{"Thantos"}, false);
        planets[0][0] = corvus;

        thantos = new Planet("Thantos", "A hot micro planet, all life can exist only underground.", new String[]{"Corvus", "New Terra"}, false);
        planets[1][0] = thantos;

        newTerra = new Planet("New Terra", "An tropical planet, it is known for its plant and animal exports.", new String[]{"Thantos", "Ligo"}, false);
        planets[2][0] = newTerra;

        ligo = new Planet("Ligo", "A moderate planet, its poles are icy and frigid.", new String[]{"New Terra", "Labyrinth"}, false);
        planets[3][0] = ligo;

        labyrinth = new Planet("Labyrinth", "A cooler planet, its maze-like caverns are home to vast quantities of metals.", new String[]{"Ligo", "Keres"}, false);
        planets[4][0] = labyrinth;

        keres = new Planet("Keres", "A desert planet, scarce resources exist on the barren land.", new String[]{"Labyrinth", "Aesop"}, false);
        planets[5][0] = keres;

        aesop = new Planet("Aesop", "A micro planet, the large crater on the planet contains the only life of the planet.", new String[]{"Keres", "Uncas"}, false);
        planets[6][0] = aesop;

        uncas = new Planet("Uncas", "A cooler planet, its two large rings are consistently harvested for their ice.", new String[]{"Aesop", "Abenaki"}, false);
        planets[7][0] = uncas;

        abenaki = new Planet("Abenaki", "A volcanic planet, it is totally uninhabitable and the warmest of the outer planets.", new String[]{"Uncas", "Pollux"}, false);
        planets[8][0] = abenaki;

        pollux = new Planet("Pollux", "An actic planet, it is heavily populated despite its temperature.", new String[]{"Abenaki", "Boreas"}, false);
        planets[9][0] = pollux;

        boreas = new Planet("Boreas", "An icy planet, the surface is completely covered with ice and snow.", new String[]{"Pollux", "Macintyre"}, false);
        planets[10][0] = boreas;

        macintyre = new Planet("Macintyre", "A frigid planet, it is a literal ball of ice.", new String[]{"Boreas", "Vanu"}, false);
        planets[11][0] = macintyre;

        vanu = new Planet("Vanu", "A bitter planet, a strange mineral underground gives the planet a purple hue.", new String[]{"Macintyre", "Gandash"}, false);
        planets[12][0] = vanu;

        gandash = new Planet("Gandash", "A metal planet, its poisonous metal gas rings are mined for its resources.", new String[]{"Vanu", "Artemisia"}, false);
        planets[13][0] = gandash;

        artemisia = new Planet("Artemisia", "A inhospitable planet, its strange climate can vary from below freezing to temperatures similar to the sun.", new String[]{"Gandash"}, false);
        planets[14][0] = artemisia;
    }

    /**
     * Prints the names, descriptions, and adjacent planets of every planet in the system.
     */
    public void printPlanets() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (!planets[i][j].name.equals("Space")) {
                    System.out.println(planets[i][j].name + ": " + planets[i][0].description + " Next to " + planets[i][0].getAdjacentPlanets());
                }
            }
        }
    }

    public Planet getPlanet(String planet) {
        String planetLower = planet.toLowerCase();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (planets[i][j].name.toLowerCase().equals(planetLower)) {
                    return planets[i][j];
                }
            }
        }
        return null;

    }
}
