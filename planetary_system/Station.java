package planetary_system;

public class Station {
    String name;
    String description;
    String inOrbitOf;
    Boolean occupied;
    String type;   

    /**
     * Constructor for station.
     * 
     * @param name The name of the station.
     * @param description The description of the station.
     * @param adjacentstations The names of the stations that are adjacent to this station.
     * @param occupied Whether or not the station is occupied, if a station is not "Space", this is 
     * true
     */
    public Station(String name, String description, String inOrbitOf, Boolean occupied, String type) {
        this.name = name;
        this.description = description;
        this.inOrbitOf = inOrbitOf;
        this.occupied = occupied;
        this.type = type;
    }

    /**
     * toString method for displaying the name, description, and what the station is in orbit around.
     * 
     * @return The name, description, and what the station is in orbit around.
     */
    @Override
    public String toString() {
        return name + ": " + description + " In orbit around " + inOrbitOf();
    }

    /**
     * This method returns the name of the station.
     * 
     * @return The name of the station.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the description of the station.
     * 
     * @return The description of the station.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method returns whether or not the station is occupied.
     * 
     * @return Whether or not the station is occupied.
     */
    public Boolean getOccupied() {
        return occupied;
    }

    /**
     * This method returns the names of the stations that are adjacent to this station
     * in a nice String.
     * 
     * @return The names of the stations that are adjacent to this station.
     */
    public String inOrbitOf() {
        return inOrbitOf;
    }

    /**
     * This method returns the type of the station.
     * 
     * @return The type of the station.
     */ 
    public String getType() {
        return type;
    }
    
    /**
     * This method gets the location of the .png file for the station in the
     * assets/stations folder to assist with displaying the station on the UI.
     * 
     * @return The location of the .png file for the station in the assets/stations folder.
     */
    public String getstationPicture() {
        return "assets/stations/" + type + ".png";
    }

    public String getstationDialogueFile() {
        return "station_dialogues/" + type + "Dialogue.txt";
    }
}
