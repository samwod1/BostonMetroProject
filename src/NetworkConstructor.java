
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NetworkConstructor {

    static ArrayList<Station> stations = createStations();
    static ArrayList<Line> stnlines = new ArrayList<>();



    public static ArrayList<Station> createStations(){
        ArrayList<ArrayList<String>> textLines = InputReader.readFile();
        ArrayList<String> lineNames = new ArrayList<>();
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < textLines.size(); i++) {
            ArrayList<String> temp = textLines.get(i);
            ArrayList l = new ArrayList();
            ArrayList connections = new ArrayList();
            for (int j = 2; j < temp.size(); j+=3) {
                l.add(temp.get(j));
                if (lineNames.contains(temp.get(j)) == false) {
                    lineNames.add(temp.get(j));
                }
                for (int k = 1; k <= 2; k++) {
                    if (connections.contains(temp.get(j+k)) == false){
                        Integer toAdd = parseInt(temp.get(j+k));
                        if (toAdd>0) {
                            connections.add(toAdd);
                        }
                    }
                }
            }
            Station s = new Station(temp.get(0),temp.get(1), l, connections);
            stations.add(s);
        }

        for (int i = 0; i < lineNames.size(); i++) {
            ArrayList s = new ArrayList();
            Line line = new Line(lineNames.get(i), s);
            //lineStns = line;
            lines.add(line);
        }

        for (int i = 0; i < stations.size(); i++) {
            ArrayList<String> stationLines = stations.get(i).getLines();
            for (int j = 0; j < stationLines.size(); j++) {
                String current = stationLines.get(j);
                for (int k = 0; k < lines.size(); k++) {
                    if (lines.get(k).getName() == current){
                        lines.get(k).addStation(stations.get(i));
                    }
                }
            }
        }
        //printStations(stations);
        return stations;
    }

    public static ArrayList<Station> getStations(){
        return stations;
    }

    //public static ArrayList<Line> getLines(){
      //  return lines;
  //  }

    public static Station stnfromStr(String stn){
        Station target = null;
        for (Station i: stations) {
            if(i.getName().equals(stn)) {
                target = i;
            }
        }

        return target;
    }

    public static Station getStnFromInt(Integer n) {
        ArrayList stations = getStations();
        Station target = null;

        for (int i = 0; i < stations.size(); i++) {
            Station current = (Station) stations.get(i);
            if (current.getNumberAsint() == n) {
                target = current;
            }
        }

        return target;
    }

    public static ArrayList<ArrayList<Station>> connections(){
        ArrayList<Station> stations = getStations();
        ArrayList<ArrayList<Station>> connections = new ArrayList<>();
        //Very dirty contains duplicates i.e. [a,b] and [b,a]
        for (int i = 0; i < stations.size(); i++) {
            Station first = stations.get(i);
            ArrayList<Integer> firstConnections = first.getConnections();
            for (int j = 0; j < firstConnections.size(); j++) {
                ArrayList<Station> conn = new ArrayList<>();
                Station second = stations.get(firstConnections.get(j)-1);
                conn.add(first);
                conn.add(second);
                connections.add(conn);
            }
        }
        System.out.println(connections);
        return connections;
    }

    public static ArrayList<ArrayList<Integer>> connectionsInts(){
        ArrayList<Station> stations = createStations();
        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        //Very dirty contains duplicates i.e. [a,b] and [b,a]
        for (int i = 0; i < stations.size(); i++) {
            Station first = stations.get(i);
            ArrayList<Integer> firstConnections = first.getConnections();
            for (int j = 0; j < firstConnections.size(); j++) {
                ArrayList<Integer> conn = new ArrayList<>();
                Station second = stations.get(firstConnections.get(j)-1);
                conn.add(first.getNumberAsint());
                conn.add(second.getNumberAsint());
                connections.add(conn);
            }
        }
        System.out.println(connections);
        return connections;
    }

    public static void printStations(List<Station> stations){
        for (int i = 0; i < stations.size(); i++) {
            System.out.println(stations.get(i).toString());
        }
    }
}
