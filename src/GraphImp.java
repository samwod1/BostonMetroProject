

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
    public ArrayList<Integer> BFS(int root, int target)
    {
       HashMap hash = constructHash(root, target);
        //System.out.println(hash);
       ArrayList<Integer> path = constructPath(hash, target);

       return path;
    }

    public void printGraph(){
        int src_vertex = 0;
        int list_size = adjList.size();

        while(src_vertex < list_size){

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
        ArrayList<Integer> visited = new ArrayList<>();
        LinkedList<Integer> agenda = new LinkedList<>();
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        boolean found = false;

        agenda.add(root);
//        System.out.println(agenda);
        hash.put(root, null);
        visited.add(root);

        while(!found) {
            int parent = agenda.poll();

            if (parent == target) {
//                System.out.println(parent);
                return hash;
            } else {

                Iterator<Integer> iterator = adjList.get(parent-1).listIterator();
                while (iterator.hasNext()){
                    int num = iterator.next();
                    agenda.add(num);
//                    System.out.println(agenda);
                    if(!visited.contains(num))
                        hash.put(num,parent);
                        visited.add(num);
                }

            }
        }

        return hash;
    }

//    public HashMap constructHash(int root, int target){
//
//        ArrayList<Integer> visited = new ArrayList<>();
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
//
//        boolean containsRoot = false;
//        boolean containsTarget = false;
//        for(int i=0; i < adjList.size(); i++){
//            if(adjList.get(i).contains(root)){
//                containsRoot = true;
//            }
//            if(adjList.get(i).contains(target)){
//                containsTarget = true;
//            }
//        }
//
//        if(!containsRoot || !containsTarget){
//            System.out.println("Please enter a valid target");
//            return hash;
//        }
//
//        queue.add(root);
//        System.out.println(queue);
//        hash.put(null, root);
//        while(true){
//            //pool is like pop but doesn't throw error when empty, just returns null
//            int parent = queue.poll();
//
////            if(parent == target)
////                return hash;
//
//
//            Iterator<Integer> iterator = adjList.get(parent-1).listIterator();
//            while (iterator.hasNext()){
//
//
//                int num = iterator.next();
//                //System.out.println("iterator.next: " + num);
//                if(!visited.contains(num)){
//                    queue.add(num);
//                    System.out.println(queue);
//                    hash.put(parent,num);
//                    if(num == target)
//                        return hash;
//                }
//
//            }
//            visited.add(parent);
//        }
//
//    }

    //create construct graph method which takes in input and crates adjacency list.
    //create other methods which add other functionality

    public void constructGraph(){



    }

}
