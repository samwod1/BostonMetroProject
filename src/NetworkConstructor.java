import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NetworkConstructor {

    public static void createStationsLines(String file){
        ArrayList textLines = InputReader.readFile(file);
        Set<String> lineNames = new HashSet<String>();
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < textLines.size(); i++) {
            String [] temp = (String[]) textLines.get(i);
            ArrayList l = new ArrayList();
            ArrayList connections = new ArrayList();
            for (int j = 2; j < temp.length; j+=3) {
                l.add(temp[j]);
                lineNames.add(temp[j]);
                connections.add(temp[j+1]);
                connections.add(temp[j+2]);
            }
            Station s = new Station(temp[0],temp[1], l, connections);
            stations.add(s);
        }
        String [] lineNamesArray = (String[]) lineNames.toArray();
        for (int i = 0; i < lineNames.size(); i++) {
            ArrayList s = new ArrayList();
            Line line = new Line(lineNamesArray[i], s);
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
    }
}
