package src;
//import com.sun.tools.jdeps.Graph;

import java.util.*;

public class GraphADT {

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

    public int getNumNodes(){
        return 1;
    }

    //takes root node and target node and stops when target node is found
    //and returns path
    public HashMap BFS(int root, int target)
    {
        boolean visited[] = new boolean[getNumNodes()];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Integer> path = new HashMap<Integer, Integer>();
        System.out.println(getNumNodes());

        visited[root] = true;
        queue.add(root);
        path.put(root, null);

        while(queue.size() != 0){
            //pool is like pop but doesn't throw error when empty, just returns null
            int parent = root;
            root = queue.poll();
            path.put(root,parent);

            if(root == target)
                return path;

            System.out.print(root+" ");

            Iterator<Integer> iterator = adjList.get(root).listIterator();
            while (iterator.hasNext()){
                int num = iterator.next();
                if(visited[num] == false){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }

        return path;
    }

    public void printGraph(){
        int src_vertex = 0;
        int list_size = adjList.size();

        while(src_vertex < list_size){
            
        }
    }
    
    //create construct graph method which takes in input and crates adjacency list.
    //create other methods which add other functionality

    public void constructGraph(){



    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        aList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(2);
        a2.add(3);
        aList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(4);
        aList.add(a3);

        ArrayList<Integer> a4 = new ArrayList<Integer>();
        a4.add(2);
        a4.add(5);
        aList.add(a4);

        GraphADT graph = new GraphADT(aList);
        System.out.print(graph);
        //graph.BFS(1,5);
    }
}
