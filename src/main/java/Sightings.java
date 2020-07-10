public class Sightings {

    private int id;
    private String location;
    private String rangerName;

    public Sightings(int id, String location, String rangerName) {
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }
}
