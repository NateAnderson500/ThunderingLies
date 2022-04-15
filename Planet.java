public class Planet {
    String name;
    String description;
    String[] adjacentPlanets;
    Boolean occupied;   

    public Planet(String name, String description, String[] adjacentPlanets, Boolean occupied) {
        this.name = name;
        this.description = description;
        this.adjacentPlanets = adjacentPlanets;
        this.occupied = occupied;
    }
}
