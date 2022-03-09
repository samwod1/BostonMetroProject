package src;
import java.util.*;

public class GraphADT {

    List<List<Integer>> adjList = new ArrayList<>();
    private int numNodes;

    ArrayList vertices = new ArrayList();
    //changed edges inner arraylist to be of type Integer
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
    //keeping these constructors seperate for the time being but we might merge them
    /*
    public GraphADT(int n) {
        this.numNodes = n;
        adjList = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }
     */

    public int nNodes()
    {
        return numNodes;
    }

    public int nEdges()
    {
        int count = 0;
        for(int i = 0; i < numNodes; i++) {
            int n = adjList.size();
            for(int j = 0; j < n; j++) {
                int a = adjList.get(i).get(j);
                if(a > i){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isEdge(int node1, int node2) {
        int i=0;
        boolean found = false;
        while (!found && i<nNodes())
        {
            if (adjList.get(node1).contains(node2))
                found = true;
            else
                i++;
        }
        return found;

    }

    public boolean addEdge(int node1, int node2) {

        if (isEdge(node1 ,node2)) {
            return false;
        }

        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1);
        return true;

    }

    public ArrayList<Integer> successors(int node)
    {
        ArrayList<Integer> successorNodes = new ArrayList<Integer>();
        for (int i=0; i<nNodes(); i++)
            if (adjList.get(node).contains(i))
                successorNodes.add(i);
        return successorNodes;
    };

    public int outDegree(int node)
    {
        return successors(node).size();
    }
    
    //create construct graph method which takes in input and crates adjacency list.
    //create other methods which add other functionality

    public void constructGraph(){



    }

}
