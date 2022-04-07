

import java.util.*;


public class GraphImp extends GraphADT {

    public GraphImp(ArrayList<ArrayList<Integer>> edges) {
        super(edges);
    }

    public int nNodes()
    {
        return numNodes;
    }

    public int nEdges()
    {
        int count = 0;
        for(int i = 0; i < numNodes; i++) {
            int n = adjList.get(i).size();
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
        ArrayList<Integer> successorNodes = new ArrayList<>();
        for (int i=0; i<nNodes(); i++)
            if (adjList.get(node).contains(i))
                successorNodes.add(i);
        return successorNodes;
    }

    public int outDegree(int node)
    {
        return successors(node).size();
    }

    //takes root node and target node and stops when target node is found
    //and returns path
    public ArrayList<Integer> BFS(int root, int target)
    {
       HashMap<Integer, Integer> hash = constructHash(root, target);
       System.out.println(hash);
       return constructPath(hash, target);
    }

    public void printGraph(){

        for(int i = 0; i < adjList.size(); i++){
            System.out.println("Conns for " + (i+1) + ":" + adjList.get(i));
        }

    }

    public ArrayList<Integer> constructPath(HashMap<Integer, Integer> map, int target){
        boolean found = false;
        ArrayList<Integer> order = new ArrayList<>();


        Integer node = target;
        while (!found) {
            Integer ancestor = map.get(node);
            order.add(0, node);
            if (ancestor == null) {
                found = true;
            }
            node = ancestor;
        }

        return order;
    }

    public HashMap<Integer, Integer> constructHash(int root, int target) {

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> agenda = new LinkedList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();

        hash.put(root, null);
        visited.add(root);
        agenda.add(root);

        while(!agenda.isEmpty()) {

            int parent = agenda.remove();

            if (parent == target) {
                return hash;
            } else {

                Iterator<Integer> iterator = adjList.get(parent-1).listIterator();

                while (iterator.hasNext()){
                    int num = iterator.next();
                    agenda.add(num);
                    if(!visited.contains(num))
                        hash.put(num,parent);
                        visited.add(num);
                }
            }
        }
        return hash;
    }
}
