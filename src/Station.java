

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Station {

    String number;
    String name;
    ArrayList<String> lines;
    ArrayList<Integer> connections;

    public Station(String number, String name, ArrayList lines, ArrayList connections) {
        this.number = number;
        this.name = name;
        this.lines = lines;
        this.connections = connections;
    }

    @Override
    public String toString() {
        return "Station{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", lines=" + lines +
                ", connections=" + connections +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getNumberAsint() {
        return parseInt(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList lines) {
        this.lines = lines;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList connections) {
        this.connections = connections;
    }
}
