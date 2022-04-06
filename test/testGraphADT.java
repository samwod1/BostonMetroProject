import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;


public class testGraphADT {

    public ArrayList<ArrayList<Integer>> simpleGraph = constructSimpleGraph();
    public ArrayList<ArrayList<Integer>> complicatedGraph = constructComplicatedGraph();
    public GraphImp simpleGraphADT = new GraphImp(simpleGraph);
    public GraphImp complicatedGraphADT = new GraphImp(complicatedGraph);

    public ArrayList<ArrayList<Integer>> constructSimpleGraph(){

        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();


        ArrayList<Integer> a02 = new ArrayList<Integer>();
        a02.add(1);
        a02.add(2);
        aList.add(a02);

        ArrayList<Integer> a20 = new ArrayList<Integer>();
        a20.add(2);
        a20.add(1);
        aList.add(a20);

        ArrayList<Integer> a04 = new ArrayList<Integer>();
        a04.add(1);
        a04.add(4);
        aList.add(a04);

        ArrayList<Integer> a40 = new ArrayList<Integer>();
        a40.add(4);
        a40.add(1);
        aList.add(a40);

        ArrayList<Integer> a45 = new ArrayList<Integer>();
        a45.add(4);
        a45.add(5);
        aList.add(a45);

        ArrayList<Integer> a54 = new ArrayList<Integer>();
        a54.add(5);
        a54.add(4);
        aList.add(a54);

        ArrayList<Integer> a46 = new ArrayList<Integer>();
        a46.add(4);
        a46.add(6);
        aList.add(a46);

        ArrayList<Integer> a64 = new ArrayList<Integer>();
        a64.add(6);
        a64.add(4);
        aList.add(a64);

        ArrayList<Integer> a13 = new ArrayList<Integer>();
        a13.add(1);
        a13.add(3);
        aList.add(a13);

        ArrayList<Integer> a31 = new ArrayList<Integer>();
        a31.add(3);
        a31.add(1);
        aList.add(a31);


        return aList;
    }

    public ArrayList<ArrayList<Integer>> constructComplicatedGraph(){
        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a31 = new ArrayList<Integer>();
        a31.add(3);
        a31.add(1);
        aList.add(a31);

        ArrayList<Integer> a13 = new ArrayList<Integer>();
        a13.add(1);
        a13.add(3);
        aList.add(a13);

        ArrayList<Integer> a12 = new ArrayList<Integer>();
        a12.add(1);
        a12.add(2);
        aList.add(a12);

        ArrayList<Integer> a21 = new ArrayList<Integer>();
        a21.add(2);
        a21.add(1);
        aList.add(a21);

        ArrayList<Integer> a34 = new ArrayList<Integer>();
        a34.add(3);
        a34.add(4);
        aList.add(a34);

        ArrayList<Integer> a43 = new ArrayList<Integer>();
        a43.add(4);
        a43.add(3);
        aList.add(a43);

        ArrayList<Integer> a45 = new ArrayList<Integer>();
        a45.add(4);
        a45.add(5);
        aList.add(a45);

        ArrayList<Integer> a54 = new ArrayList<Integer>();
        a54.add(5);
        a54.add(4);
        aList.add(a54);

        ArrayList<Integer> a310 = new ArrayList<Integer>();
        a310.add(3);
        a310.add(10);
        aList.add(a310);

        ArrayList<Integer> a103 = new ArrayList<Integer>();
        a103.add(10);
        a103.add(3);
        aList.add(a103);

        ArrayList<Integer> a1012 = new ArrayList<Integer>();
        a103.add(10);
        a103.add(12);
        aList.add(a1012);


        ArrayList<Integer> a1210 = new ArrayList<Integer>();
        a1210.add(12);
        a1210.add(10);
        aList.add(a1210);

        ArrayList<Integer> a39 = new ArrayList<Integer>();
        a39.add(3);
        a39.add(9);
        aList.add(a39);

        ArrayList<Integer> a93 = new ArrayList<Integer>();
        a93.add(9);
        a93.add(3);
        aList.add(a93);

        ArrayList<Integer> a98 = new ArrayList<Integer>();
        a98.add(9);
        a98.add(8);
        aList.add(a98);

        ArrayList<Integer> a89 = new ArrayList<Integer>();
        a89.add(8);
        a89.add(9);
        aList.add(a89);

        ArrayList<Integer> a87 = new ArrayList<Integer>();
        a87.add(8);
        a87.add(7);
        aList.add(a87);

        ArrayList<Integer> a78 = new ArrayList<Integer>();
        a78.add(7);
        a78.add(8);
        aList.add(a78);

        ArrayList<Integer> a711 = new ArrayList<Integer>();
        a711.add(7);
        a711.add(11);
        aList.add(a711);

        ArrayList<Integer> a117 = new ArrayList<Integer>();
        a117.add(11);
        a117.add(7);
        aList.add(a117);

        ArrayList<Integer> a70 = new ArrayList<Integer>();
        a70.add(7);
        a70.add(1);
        aList.add(a70);

        ArrayList<Integer> a07 = new ArrayList<Integer>();
        a07.add(1);
        a07.add(7);
        aList.add(a07);

        return aList;

    }

    @Test
    public void print(){

        System.out.println(complicatedGraph);
    }
}
