package src;

import java.util.ArrayList;

public class Station {

    String number;
    String name;
    ArrayList<String> lines;
    ArrayList<Station> connections;

    public Station(String number, String name, ArrayList lines, ArrayList connections) {
        this.number = number;
        this.name = name;
        this.lines = lines;
        this.connections = connections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getLines() {
        return lines;
    }

    public void setLines(ArrayList lines) {
        this.lines = lines;
    }

    public ArrayList getConnections() {
        return connections;
    }

    public void setConnections(ArrayList connections) {
        this.connections = connections;
    }
}
