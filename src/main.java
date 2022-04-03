import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        inputReader.readFile();
        NetworkConstructor networkConstructor = new NetworkConstructor();
        ArrayList<Station> stations = networkConstructor.createStations();
        networkConstructor.connections();
        Route route = new Route();
        System.out.println(stations.get(3));
        System.out.println(stations.get(5));

        Station revbeach = stations.get(3);
        Station beachm = stations.get(5);

        System.out.println(route.makeRoute(revbeach, beachm));



    }

}
