

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
       //int[] s = solve(root);
       System.out.println(hash);
      // ArrayList<Integer> path = reconstructPath(root, target, s);
        ArrayList<Integer> path = constructPath(hash, target);

       return path;
    }

    public void printGraph(){
        int src_vertex = 0;
        int list_size = adjList.size();
    }

//    public ArrayList<Integer> constructPath(HashMap<Integer, Integer> map){
//        Integer root = null;
//        ArrayList<Integer> order = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
//            Integer ancestor = set.getKey();
//            if (ancestor == null) {
//                root = set.getValue();
//            }
//
//        }
//        order.add(root);
//
//        //need to find a way of getting the order from the root,
//        // may need to change the structure of hashmap in bfs
//        for (int i = 0; i < map.size(); i++) {
//            Integer child = map.get(root);
//            order.add(child);
//            root = child;
//        }
//
//        return order;
//
//    }

//    for (Map.Entry<Integer, Integer> set : map.entrySet()) {
//            Integer ancestor = map.get(set.getKey());
//            if (ancestor == null) {
//                root = set.getKey();
//            }
//
//        }
//        order.add(root);

        //need to find a way of getting the order from the root,
        // may need to change the structure of hashmap in bfs
//        for (int i = 0; i < map.size(); i++) {
//            Integer child = map.get(root);
//            order.add(child);
//            root = child;
//        }


    public ArrayList<Integer> constructPath(HashMap<Integer, Integer> map, int target){
//        Integer root = null;
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

    public  ArrayList<Integer> reconstructPath(int s, int e, int[] prev){
        ArrayList<Integer> path = new ArrayList<>();
        int at = e;
        while(at != s){
            path.add(at);
            at = prev[at];
        }

        return path;
    }


    public int[] solve(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        boolean[] visited = new boolean[nNodes()];
        visited[s] = true;

        int[] prev = new int[nNodes()];

        while(!q.isEmpty()){
            int node = q.remove();
            List<Integer> neighbours = adjList.get(node-1);

            for(int next : neighbours){
                if(!visited[next-1]){
                    q.add(next);
                    visited[next-1] = true;
                    prev[next-1] = node;
                }
            }
        }

        return prev;

    }



    public HashMap<Integer, Integer> constructHash(int root, int target) {

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> agenda = new LinkedList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        boolean found = false;

//        System.out.println(agenda);
        hash.put(root, null);
        visited.add(root);
        agenda.add(root);

        while(!agenda.isEmpty()) {

            int parent = agenda.remove();

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

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        aList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(1);
        a2.add(3);
        aList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(4);
        aList.add(a3);

        ArrayList<Integer> a4 = new ArrayList<Integer>();
        a4.add(1);
        a4.add(5);
        aList.add(a4);

        ArrayList<Integer> a5 = new ArrayList<Integer>();
        a5.add(5);
        a5.add(6);
        aList.add(a5);

        ArrayList<Integer> a6 = new ArrayList<Integer>();
        a6.add(5);
        a6.add(7);
        aList.add(a6);

        ArrayList<Integer> a7 = new ArrayList<Integer>();
        a7.add(7);
        a7.add(8);
        aList.add(a7);


        GraphImp graph = new GraphImp(aList);
        //System.out.print(graph);
        System.out.println(graph.BFS(1,8));
    }
}
