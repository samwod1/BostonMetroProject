import java.util.ArrayList;

public class NetworkConstructor {

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
                        connections.add(temp.get(j+k));
                    }
                }
            }
            Station s = new Station(temp.get(0),temp.get(1), l, connections);
            stations.add(s);
        }

        for (int i = 0; i < lineNames.size(); i++) {
            ArrayList s = new ArrayList();
            Line line = new Line(lineNames.get(i), s);
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

    public static void printStations(ArrayList stations){
        for (int i = 0; i < stations.size(); i++) {
            System.out.println(stations.get(i).toString());
        }
    }
}
