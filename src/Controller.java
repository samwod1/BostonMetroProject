import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Controller {
    private static NetworkConstructor nwc = new NetworkConstructor();

    //need to make a function to tell when there's a change of line

    //NetworkConstructor nwc = new NetworkConstructor();

    public void run() {
        //   NetworkConstructor nwc = new NetworkConstructor();
        Route route = new Route();

        Station stn1 = nwc.stations.get(11);
        System.out.println(stn1);
        Station stn2 = nwc.stations.get(0);
        System.out.println(stn2);

        System.out.println(route.makeRoute(stn2,stn1));

        Station stn3 = nwc.stnfromStr("Wellington");
        System.out.println(stn3);

        Station stn4 = nwc.stnfromStr("Aquarium");
        System.out.println(stn4);

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
        current = current.replaceAll("[^a-zA-Z]", "");
        dest = dest.replaceAll("[^a-zA-Z]", "");
        boolean curExists = false;
        boolean destExists = false;
        ArrayList<Station> stations = NetworkConstructor.getStations();
        for (Station station : stations) {
            String stnName = station.getName();
            stnName = stnName.replaceAll("[^a-zA-Z]", "");
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

    public ArrayList<String> getLineNames(){
        return NetworkConstructor.getLineNames();
    }



}
