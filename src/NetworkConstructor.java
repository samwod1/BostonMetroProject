import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class NetworkConstructor {

    static ArrayList<Station> stations = createStations();
    static ArrayList<Line> lines = createLines();
    static ArrayList<String> lineNames = new ArrayList<>();
    static String file = "src\\bostonmetro.txt";


    public static ArrayList<Station> createStations(){
        ArrayList<ArrayList<String>> textLines = InputReader.readFile("src\\bostonmetro.txt");
        lineNames = new ArrayList<>();
        ArrayList<Station> stations = new ArrayList<>();

        for (ArrayList<String> temp : textLines) {
            ArrayList l = new ArrayList();
            ArrayList connections = new ArrayList();
            for (int j = 2; j < temp.size(); j += 3) {
                l.add(temp.get(j));
                if (!lineNames.contains(temp.get(j))) {
                    lineNames.add(temp.get(j));
//                    System.out.println("|||||" + lineNames);
                }
                for (int k = 1; k <= 2; k++) {
                    if (!connections.contains(temp.get(j + k))) {
                        Integer toAdd = parseInt(temp.get(j + k));
                        if (toAdd > 0) {
                            connections.add(toAdd);
                        }
                    }
                }
            }
            Station s = new Station(temp.get(0), temp.get(1), l, connections);
            stations.add(s);
        }
        return stations;
    }


    public static ArrayList<Line> createLines(){
        ArrayList<Line> lines = new ArrayList<>();

        //System.out.println("Innest " + lineNames);
        for (int i = 0; i < Objects.requireNonNull(lineNames).size(); i++) {
            ArrayList<Station> lineStns = new ArrayList<>();
            for (Station station : stations) {
                ArrayList<String> arrLines = station.getLines();
                for (String arrLine : arrLines) {
                    if (lineNames.get(i).equals(arrLine)) {
                        lineStns.add(station);
//                        System.out.println("Innest");
                    }
                }
//                System.out.println("Innest");
            }
            Line l = new Line(lineNames.get(i), lineStns);
            lines.add(l);
        }
        return lines;
    }


    public static ArrayList<Station> getStations(){
        return stations;
    }

    public static ArrayList<Line> getStnlines(){
        return lines;
    }



    public static ArrayList<String> getLineNames(){
        return lineNames;
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

        for (Object station : stations) {
            Station current = (Station) station;
            if (current.getNumberAsint().equals(n)) {
                target = current;
            }
        }

        return target;
    }

    public static ArrayList<ArrayList<Station>> connections(){
        ArrayList<Station> stations = getStations();
        ArrayList<ArrayList<Station>> connections = new ArrayList<>();
        //Very dirty contains duplicates i.e. [a,b] and [b,a]
        for (Station first : stations) {
            ArrayList<Integer> firstConnections = first.getConnections();
            for (Integer firstConnection : firstConnections) {
                ArrayList<Station> conn = new ArrayList<>();
                Station second = stations.get(firstConnection - 1);
                conn.add(first);
                conn.add(second);
                connections.add(conn);
            }
        }
//        System.out.println(connections);
        return connections;
    }

    public static ArrayList<ArrayList<Integer>> connectionsInts(){
        ArrayList<Station> stations = createStations();
        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        //Very dirty contains duplicates i.e. [a,b] and [b,a]
        for (Station first : stations) {
            ArrayList<Integer> firstConnections = first.getConnections();
            for (Integer firstConnection : firstConnections) {
                ArrayList<Integer> conn = new ArrayList<>();
                Station second = stations.get(firstConnection - 1);
                conn.add(first.getNumberAsint());
                conn.add(second.getNumberAsint());
                connections.add(conn);
            }
        }
//        System.out.println(connections);
        return connections;
    }

    public static void printStations(List<Station> stations){
        for (Station station : stations) {
            System.out.println(station.toString());
        }
    }
}
