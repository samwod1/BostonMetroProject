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
        String station1 = n1.getName();
        Integer n1int = n1.getNumberAsint();
        Integer n2int = n2.getNumberAsint();

        //HashMap<Integer, Integer> hashpath = graph.BFS(n1int, n2int);
        ArrayList<Station> path = new ArrayList<>();

        ArrayList<Integer> intPath = graph.BFS(n1int,n2int);

        for (int i = 0; i < intPath.size(); i++) {
            path.add(NetworkConstructor.getStnFromInt(intPath.get(i)));
        }

        return path;
    }



}
