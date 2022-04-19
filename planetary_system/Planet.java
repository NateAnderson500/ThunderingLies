package planetary_system;

public class Planet {
    String name;
    String description;
    String[] adjacentPlanets;
    Boolean occupied;   

    /**
     * Constructor for Planet.
     * 
     * @param name The name of the planet.
     * @param description The description of the planet.
     * @param adjacentPlanets The names of the planets that are adjacent to this planet.
     * @param occupied Whether or not the planet is occupied, if a planet is not "Space", this is 
     * true
     */
    public Planet(String name, String description, String[] adjacentPlanets, Boolean occupied) {
        this.name = name;
        this.description = description;
        this.adjacentPlanets = adjacentPlanets;
        this.occupied = occupied;
    }

    /**
     * toString method for displaying the name, description, and adjacent planets of a planet.
     * 
     * @return The name, description, and adjacent planets of a planet.
     */
    @Override
    public String toString() {
        return name + ": " + description + " Next to " + getAdjacentPlanets();
    }

    /**
     * This method returns the name of the planet.
     * 
     * @return The name of the planet.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the description of the planet.
     * 
     * @return The description of the planet.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method returns whether or not the planet is occupied.
     * 
     * @return Whether or not the planet is occupied.
     */
    public Boolean getOccupied() {
        return occupied;
    }

    /**
     * This method returns the names of the planets that are adjacent to this planet.
     * 
     * @return The names of the planets that are adjacent to this planet.
     */
    public String getAdjacentPlanets() {
        String s = "";
        if (adjacentPlanets.length == 1) {
            s += adjacentPlanets[0];
            
        }
        else {
            s += adjacentPlanets[0] + " and " + adjacentPlanets[1];
        }
        return s;
    }

    /**
     * This method gets the location of the .png file for the planet in the
     * assets/planets folder to assist with displaying the planet on the UI.
     * 
     * @return The location of the .png file for the planet in the assets/planets folder.
     */
    public String getPlanetPicture() {
        return "assets/planets/" + name + ".png";
    }

    public String getPlanetDialogueFile() {
        return "planet_dialogues/" + name + "Dialogue.txt";
    }
}