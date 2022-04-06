import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Controller {
    private static NetworkConstructor nwc = new NetworkConstructor();
    Route route = new Route();

    //need to make a function to tell when there's a change of line


    public void run() {
        //NetworkConstructor nwc = new NetworkConstructor();
       // Route route = new Route();

        Station stn1 = nwc.stations.get(11);
//        System.out.println(stn1);
        Station stn2 = nwc.stations.get(0);
//        System.out.println(stn2);

//        System.out.println(route.makeRoute(stn2,stn1));

        Station stn3 = nwc.stnfromStr("Wellington");
        //System.out.println(stn3);

        Station stn4 = nwc.stnfromStr("PleasantStreet");
        //System.out.println(stn4);

        System.out.println(route.makeRoute(stn4,stn3));

    }

    /**
    public void mainRun() {
        NetworkConstructor.createStations();
        lineFromStr("23");
    }
*/

    /**
    public Station stnfromstr(String stn){

    }
     * @return*/

   // List<Station>

    public Boolean[] errorCheck(String current, String dest) {
        current = current.replaceAll("[^A-Za-z0-9/.']", "");
        dest = dest.replaceAll("[^A-Za-z0-9/.']", "");
        boolean curExists = false;
        boolean destExists = false;
        ArrayList<Station> stations = NetworkConstructor.getStations();
        for (Station station : stations) {
            String stnName = station.getName();
            stnName = stnName.replaceAll("[^A-Za-z0-9/.']", "");
            if (current.equalsIgnoreCase(stnName)) {
                curExists = true;
            }
            if (dest.equalsIgnoreCase(stnName)) {
                destExists = true;
            }
            if (destExists && curExists) {
                break;
            }
        }
        return new Boolean[]{curExists, destExists};
        //  ArrayList lineStn = nwc.getStations();
        // System.out.println(lineStn);
        //   return lineStn;
    }

    //ArrayList<Line>


    public ArrayList<String> getLineStations(String linestr) {
        ArrayList<Line> lines = NetworkConstructor.getStnlines();
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {

            if(linestr.equals(lines.get(i).getName())) {
                ArrayList<Station> stn = lines.get(i).getStations();
                for (int j = 0; j < stn.size(); j++) {
                    String stnName = stn.get(j).getName();
                    nameList.add(stnName);
                }
            }

        }
        return nameList;
    }
    
    public ArrayList<String[]> getLineRoute(String to, String from){
        Station stnTo = NetworkConstructor.getStationByName(to);
        Station stnFrom = NetworkConstructor.getStationByName(from);
        ArrayList<Station> routeStns = route.makeRoute(stnTo,stnFrom);
        ArrayList<String[]> stationsAndLines = new ArrayList<>();

        for (int i = 0; i < routeStns.size(); i++) {
          //  String threeLines = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i-1).getLines());
            //For first place
            String line = "";
            if(i==0) {
                line = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i+2).getLines());
                if (line=="") {
                    line = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i+1).getLines());
                }
                String[] stnLine = {routeStns.get(i).getName(), line};
                stationsAndLines.add(stnLine);
            }
            //One before and one after upper limit
            else if (i+1<routeStns.size()) {
                line = stationLinesCompare(routeStns.get(i+1).getLines(), routeStns.get(i-1).getLines());
                if (line=="") {
                    line = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i-1).getLines());
                }
                String[] stnLine = {routeStns.get(i).getName(), line};
                stationsAndLines.add(stnLine);
            }
            //For once you reach end
            else if (i>1){
                line = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i-2).getLines());
                if (line=="") {
                    line = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i-1).getLines());
                }
                String[] stnLine = {routeStns.get(i).getName(), line};
                stationsAndLines.add(stnLine);

            }
            else{
                line = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i-1).getLines());
                String[] stnLine = {routeStns.get(i).getName(), line};
                stationsAndLines.add(stnLine);
            }
            /**
            if (routeStns.get(i).getLines().size() == 1){
                String[] stationAndLine = {routeStns.get(i).getName(), routeStns.get(i).getLines().get(0)};
                stationsAndLines.add(stationAndLine);
            }
            else if(i==0){
                if (routeStns.size()>2) {
                    ArrayList<String> lines = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i + 2).getLines());
                    if (lines.size() > 0) {
                        String[] stationAndLine = {routeStns.get(i).getName(), lines.get(0)};
                        stationsAndLines.add(stationAndLine);
                    } else {
                        lines = stationLinesCompare(routeStns.get(i).getLines(), routeStns.get(i + 1).getLines());
                        String[] stationAndLine = {routeStns.get(i).getName(), lines.get(0)};
                        stationsAndLines.add(stationAndLine);
                    }
                }
            }
            else if (routeStns.size()-i <= 1){
                ArrayList<String> lines = stationLinesCompare(routeStns.get(i-1).getLines(), routeStns.get(i+1).getLines());
                if (lines.size()>0){
                    String[] stationAndLine = {routeStns.get(i).getName(), lines.get(0)};
                    stationsAndLines.add(stationAndLine);
                }
                else{
                    lines = stationLinesCompare(routeStns.get(i-1).getLines(), routeStns.get(i).getLines());
                    String[] stationAndLine = {routeStns.get(i).getName(), lines.get(0)};
                    stationsAndLines.add(stationAndLine);
                }
            }
            else{
                ArrayList<String> lines = stationLinesCompare(routeStns.get(i-2).getLines(), routeStns.get(i).getLines());
                if (lines.size()>0){
                    String[] stationAndLine = {routeStns.get(i).getName(), lines.get(0)};
                    stationsAndLines.add(stationAndLine);
                }
                else{
                    lines = stationLinesCompare(routeStns.get(i-1).getLines(), routeStns.get(i).getLines());
                    String[] stationAndLine = {routeStns.get(i).getName(), lines.get(0)};
                    stationsAndLines.add(stationAndLine);
                }
            }
             */
        }
        return stationsAndLines;
    }


    /**
    public String StationLinesCompareBF(ArrayList<String> behind, ArrayList<String> middle, ArrayList<String> front){
        for (int i = 0; i < behind.size(); i++) {
            for (int j = 0; j < middle.size(); j++) {
                for (int k = 0; k < front.size(); k++) {
                    if (behind.get(i).equals(middle.get(j)) && middle.get(i).equals(front.get(j))){
                        String line = behind.get(i);
                        return line;
                    }
                   // return first.get(i);
                }
            }
        }
        return null;
    }
*/

    public String stationLinesCompare(ArrayList<String> first, ArrayList<String> second){
       // ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                if (first.get(i).equals(second.get(j))){

                   // lines.add(first.get(i));
                    return first.get(i);
                }
            }
        }
        return "";
    }
    //  Orange
    //  -Stn1
    //  -stn2
    //  Orange - Green

    // linename line
    // linename line1 line2
    //
    /**
    public ArrayList<String> stationLinesCompare(ArrayList<String> first, ArrayList<String> second){
         ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                if (first.get(i).equals(second.get(j))){
                    lines.add(first.get(i));
                }
            }
        }
        return lines;
    }
*/
    public Boolean lineDecider(ArrayList<String> lines){
         if (lines.size() > 0){
             return true;
         }
         return false;
    }

    public ArrayList<String> getLineNames(){
        return NetworkConstructor.getLineNames();
    }



}
