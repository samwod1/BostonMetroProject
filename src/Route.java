import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Route {
    //need list of edges of node stations

    //[[state, downtown crossing],[state, government center],[

    public ArrayList<ArrayList<Integer>> cons = NetworkConstructor.connectionsInts();

    public GraphImp graph = new GraphImp(cons);



    public ArrayList<Station> makeRoute(Station n1, Station n2) {

        Integer n1int = n1.getNumberAsint();
        Integer n2int = n2.getNumberAsint();

        HashMap<Integer, Integer> hashpath = graph.BFS(n1int, n2int);
        ArrayList<Station> path = new ArrayList<>();

        //path as list of tuples {stationName, [line]}
        for (Map.Entry<Integer, Integer> set : hashpath.entrySet()) {
            Integer stnNumber = set.getKey();
            Station current = getStnFromInt(stnNumber);

        }

        return path;
    }

    public ArrayList<Integer> getOrderFromHash(HashMap<Integer, Integer> map) {
        Integer root = null;
        ArrayList<Integer> order = new ArrayList<>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            Integer ancestor = set.getValue();
            if (ancestor == null) {
                root = set.getKey();
            }

        }

        order.add(root);

        //need to find a way of getting the order from the root,
        // may need to change the structure of hashmap in bfs

    }

    public Station getStnFromInt(Integer n) {
        ArrayList stations = NetworkConstructor.createStations();
        Station target = null;

        for (int i = 0; i < stations.size(); i++) {
            Station current = (Station) stations.get(i);
            if (current.getNumberAsint() == n) {
                target = current;
            }
        }

        return target;
    }


}
