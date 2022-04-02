import java.util.ArrayList;

public class Route {
    //need list of edges of node stations

    //[[state, downtown crossing],[state, government center],[

    GraphImp graph = new GraphImp(//list in here);

    public Route makeRoute(Station n1, Station n2) {
        //find lines of each station
        ArrayList linesn1 = n1.getLines();
        ArrayList linesn2 = n2.getLines();

        boolean sameLine = false;

        //find if they share a line
        for (int i = 0; i < linesn1.size(); i++) {
            if(linesn2.contains(linesn1.get(i))) {
                sameLine = true;
            }
        }

        Station connect1;
        Station connect2;

        if (!sameLine) {

            //checking if start and end are nodes
            if (linesn1.size() > 1) {
                connect1 = n1;
            } else {
                connect1 = closestNodeStation(n1);
            }

            if (linesn2.size() > 1) {
                connect2 = n2;
            } else {
                connect2 = closestNodeStation(n2);
            }


            //send the connections to graph to find route
            graph.BFS();
        }

        return path;
    }

    public Station closestNodeStation(Station s) {
        ArrayList cons = s.getConnections();
        Station next = (Station) cons.get(0);
        int nextsize = (next.getLines()).size();

        if (nextsize > 1) {
            return next;
        } else {
            closestNodeStation(next);
        }
        return null;
    }

}
