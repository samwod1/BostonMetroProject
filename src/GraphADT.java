//import com.sun.tools.jdeps.Graph;

import java.util.*;

public abstract class GraphADT {

    List<List<Integer>> adjList = new ArrayList<>();
    public int numNodes;
    ArrayList<ArrayList<Integer>> edges;


    public GraphADT(ArrayList<ArrayList<Integer>> edges){

        this.edges = edges;
        //find max position to intiliase arrayList the adjList
        int maxNodes = 0;

        for(int i = 0; i < edges.size(); i++){
            if(edges.get(i).get(0) > maxNodes)
                maxNodes = edges.get(i).get(0); //assigns root node of edge to max
            if(edges.get(i).get(1) > maxNodes)
                maxNodes = edges.get(i).get(1);
        }

        this.numNodes = maxNodes;
        System.out.println("maxNodes: " + maxNodes);
        //intiliases adjList
        for(int i = 0; i < maxNodes; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            adjList.add(temp);
        }

        //System.out.println("adjList size: " + adjList.size());

        for(int i = 0; i < edges.size(); i++){
            adjList.get(edges.get(i).get(1) - 1).add(edges.get(i).get(0));
//            adjList.get(edges.get(i).get(0) - 1).add(edges.get(i).get(1));
        }

//        for(int i = 0; i < adjList.size(); i++){
//            System.out.println("Conns for " + (i+1) + ":" + adjList.get(i));
//        }

    }


    public abstract int nNodes();

    public abstract int nEdges();

    public abstract boolean isEdge(int node1, int node2);

    public abstract boolean addEdge(int node1, int node2);

    public abstract ArrayList<Integer> successors(int node);

    public abstract int outDegree(int node);

    //takes root node and target node and stops when target node is found
    //and returns path
    public abstract ArrayList<Integer> BFS(int root, int target);

    public abstract ArrayList<Integer> constructPath(HashMap<Integer, Integer> map, int target);

    public abstract HashMap<Integer, Integer> constructHash(int root, int target);

    public abstract void printGraph();

}
