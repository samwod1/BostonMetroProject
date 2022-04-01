
import java.util.ArrayList;

public class Line {
    String name;
    ArrayList stations;

    public Line(String name, ArrayList stations) {
        this.name = name;
        this.stations = stations;
    }

    public void addStation(Station station){
        this.stations.add(station);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getStations() {
        return stations;
    }

    public void setStations(ArrayList stations) {
        this.stations = stations;
    }
}
