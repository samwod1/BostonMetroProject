//import com.sun.tools.jdeps.Graph;

import java.util.*;

public abstract class GraphADT {

    List<List<Integer>> adjList = new ArrayList<>();
    private int numNodes;

    ArrayList vertices = new ArrayList();
    // changed edges inner arraylist to be of type Integer
    ArrayList<ArrayList<Integer>> edges = new ArrayList();
    // temp removing vertices

    public GraphADT(/*ArrayList vertices,*/ ArrayList<ArrayList<Integer>> edges){

        this.edges = edges;
        numNodes = edges.size();

        for (int i = 0; i < numNodes; i++)
            adjList.add(i, new ArrayList<>());

        for(ArrayList<Integer> e : edges){
            //gets source and adds new adjancent node
            adjList.get(e.get(0)).add(e.get(1));
        }

    }

    public abstract int nNodes();

    public abstract int nEdges();

    public abstract boolean isEdge(int node1, int node2);

    public abstract boolean addEdge(int node1, int node2);

    public abstract ArrayList<Integer> successors(int node);

    public abstract int outDegree(int node);

    public abstract int getNumNodes();

    //takes root node and target node and stops when target node is found
    //and returns path
    public abstract HashMap BFS(int root, int target);

    public abstract void printGraph();
    
    //create construct graph method which takes in input and crates adjacency list.
    //create other methods which add other functionality

    public abstract void constructGraph();

}
