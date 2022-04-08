
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import static org.junit.Assert.*;


public class testGraphADT {

    public ArrayList<ArrayList<Integer>> simpleGraph = constructSimpleGraph();
    public ArrayList<ArrayList<Integer>> complicatedGraph = constructComplicatedGraph();
    public GraphImp simpleGraphADT = new GraphImp(simpleGraph);
    public GraphImp complicatedGraphADT = new GraphImp(complicatedGraph);

    public ArrayList<ArrayList<Integer>> constructSimpleGraph(){

        ArrayList<ArrayList<Integer>> aList = new ArrayList<>();


        ArrayList<Integer> a02 = new ArrayList<>();
        a02.add(1);
        a02.add(2);
        aList.add(a02);

        ArrayList<Integer> a20 = new ArrayList<>();
        a20.add(2);
        a20.add(1);
        aList.add(a20);

        ArrayList<Integer> a04 = new ArrayList<>();
        a04.add(1);
        a04.add(4);
        aList.add(a04);

        ArrayList<Integer> a40 = new ArrayList<>();
        a40.add(4);
        a40.add(1);
        aList.add(a40);

        ArrayList<Integer> a45 = new ArrayList<>();
        a45.add(4);
        a45.add(5);
        aList.add(a45);

        ArrayList<Integer> a54 = new ArrayList<>();
        a54.add(5);
        a54.add(4);
        aList.add(a54);

        ArrayList<Integer> a46 = new ArrayList<>();
        a46.add(4);
        a46.add(6);
        aList.add(a46);

        ArrayList<Integer> a64 = new ArrayList<>();
        a64.add(6);
        a64.add(4);
        aList.add(a64);

        ArrayList<Integer> a13 = new ArrayList<>();
        a13.add(1);
        a13.add(3);
        aList.add(a13);

        ArrayList<Integer> a31 = new ArrayList<>();
        a31.add(3);
        a31.add(1);
        aList.add(a31);


        return aList;
    }

    public ArrayList<ArrayList<Integer>> constructComplicatedGraph(){
        ArrayList<ArrayList<Integer>> bList = new ArrayList<>();

        ArrayList<Integer> a31 = new ArrayList<>();
        a31.add(3);
        a31.add(1);
        bList.add(a31);

        ArrayList<Integer> a13 = new ArrayList<>();
        a13.add(1);
        a13.add(3);
        bList.add(a13);

        ArrayList<Integer> a12 = new ArrayList<>();
        a12.add(1);
        a12.add(2);
        bList.add(a12);

        ArrayList<Integer> a21 = new ArrayList<>();
        a21.add(2);
        a21.add(1);
        bList.add(a21);

        ArrayList<Integer> a34 = new ArrayList<>();
        a34.add(3);
        a34.add(4);
        bList.add(a34);

        ArrayList<Integer> a43 = new ArrayList<>();
        a43.add(4);
        a43.add(3);
        bList.add(a43);

        ArrayList<Integer> a45 = new ArrayList<>();
        a45.add(4);
        a45.add(5);
        bList.add(a45);

        ArrayList<Integer> a54 = new ArrayList<>();
        a54.add(5);
        a54.add(4);
        bList.add(a54);

        ArrayList<Integer> a310 = new ArrayList<>();
        a310.add(3);
        a310.add(10);
        bList.add(a310);

        ArrayList<Integer> a103 = new ArrayList<>();
        a103.add(10);
        a103.add(3);
        bList.add(a103);

        ArrayList<Integer> a1012 = new ArrayList<>();
        a1012.add(10);
        a1012.add(12);
        bList.add(a1012);


        ArrayList<Integer> a1210 = new ArrayList<>();
        a1210.add(12);
        a1210.add(10);
        bList.add(a1210);

        ArrayList<Integer> a39 = new ArrayList<>();
        a39.add(3);
        a39.add(9);
        bList.add(a39);

        ArrayList<Integer> a93 = new ArrayList<>();
        a93.add(9);
        a93.add(3);
        bList.add(a93);

        ArrayList<Integer> a98 = new ArrayList<>();
        a98.add(9);
        a98.add(8);
        bList.add(a98);

        ArrayList<Integer> a89 = new ArrayList<>();
        a89.add(8);
        a89.add(9);
        bList.add(a89);

        ArrayList<Integer> a87 = new ArrayList<>();
        a87.add(8);
        a87.add(7);
        bList.add(a87);

        ArrayList<Integer> a78 = new ArrayList<>();
        a78.add(7);
        a78.add(8);
        bList.add(a78);

        ArrayList<Integer> a711 = new ArrayList<>();
        a711.add(7);
        a711.add(11);
        bList.add(a711);

        ArrayList<Integer> a117 = new ArrayList<>();
        a117.add(11);
        a117.add(7);
        bList.add(a117);

        ArrayList<Integer> a70 = new ArrayList<>();
        a70.add(7);
        a70.add(1);
        bList.add(a70);

        ArrayList<Integer> a07 = new ArrayList<>();
        a07.add(1);
        a07.add(7);
        bList.add(a07);

        //System.out.println(bList);

        return bList;

    }

    @Test
    public void testSimpleGraphConstructor(){


        ArrayList<Integer> connection1 = new ArrayList<>();
        connection1.add(2);
        connection1.add(4);
        connection1.add(3);
        assertEquals(simpleGraphADT.adjList.get(0), connection1);

        connection1.clear();
        connection1.add(1);
        connection1.add(5);
        connection1.add(6);
        assertEquals(simpleGraphADT.adjList.get(3), connection1);

        connection1.clear();
        connection1.add(4);
        assertEquals(simpleGraphADT.adjList.get(5), connection1);

    }

    @Test
    public void testSimpleGraphNodes(){
        assertEquals(simpleGraphADT.nNodes(), 6);
    }

    @Test
    public void testSimpleGraphEdges(){
        assertEquals(simpleGraphADT.nEdges(), 5);
    }

    @Test
    public void testComplicatedGraphConstuctor(){

        ArrayList<Integer> connection1 = new ArrayList<>();
        connection1.add(3);
        connection1.add(2);
        connection1.add(7);
        assertEquals(complicatedGraphADT.adjList.get(0), connection1);

        connection1.clear();
        connection1.add(3);
        connection1.add(5);
        assertEquals(complicatedGraphADT.adjList.get(3), connection1);

        connection1.clear();
        assertEquals(complicatedGraphADT.adjList.get(5), connection1);

    }

    @Test
    public void testComplicatedGraphNodes(){
        assertEquals(complicatedGraphADT.nNodes(), 12);
    }

    @Test
    public void testComplicatedGraphEdges(){
        assertEquals(complicatedGraphADT.nEdges(), 11);
    }

    @Test
    public void testSimpleGraphBFS(){
        ArrayList<Integer> path = simpleGraphADT.BFS(1,6);
        ArrayList<Integer> pathTest = new ArrayList<Integer>();
        pathTest.add(1);
        pathTest.add(4);
        pathTest.add(6);
        assertEquals(path, pathTest);

        path = simpleGraphADT.BFS(6,1);
        pathTest.clear();
        pathTest.add(6);
        pathTest.add(4);
        pathTest.add(1);
        assertEquals(path, pathTest);

        path = simpleGraphADT.BFS(5,3);
        pathTest.clear();
        pathTest.add(5);
        pathTest.add(4);
        pathTest.add(1);
        pathTest.add(3);
        assertEquals(path,pathTest);
    }

    @Test
    public void testComplicatedGraph(){
        ArrayList<Integer> path = complicatedGraphADT.BFS(1,12);
        ArrayList<Integer> pathTest = new ArrayList<Integer>();
        pathTest.add(1);
        pathTest.add(3);
        pathTest.add(10);
        pathTest.add(12);
        assertEquals(path, pathTest);

        path = complicatedGraphADT.BFS(12,1);
        pathTest.clear();
        pathTest.add(12);
        pathTest.add(10);
        pathTest.add(3);
        pathTest.add(1);
        assertEquals(path, pathTest);

        path = complicatedGraphADT.BFS(8, 3);
        pathTest.clear();
        pathTest.add(8);
        pathTest.add(9);
        pathTest.add(3);
        assertEquals(path, pathTest);
    }

}
