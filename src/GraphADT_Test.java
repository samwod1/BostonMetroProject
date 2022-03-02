import java.lang.reflect.Array;
import java.util.*;

public class GraphADT_Test {

    public void test() {
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        vertices.add(1);
        vertices.add(2);
        vertices.add(3);
        vertices.add(4);

        ArrayList<ArrayList> edges = new ArrayList<>();
        ArrayList<Integer> onecon = new ArrayList<Integer>();
        onecon.add(2);
        onecon.add(3);

        ArrayList<Integer> twocon = new ArrayList<Integer>();
        twocon.add(1);
        twocon.add(3);

        ArrayList<Integer> threecon = new ArrayList<Integer>();
        threecon.add(1);
        threecon.add(2);

        ArrayList<Integer> fourcon = new ArrayList<Integer>();
        fourcon.add(3);

        edges.add(onecon);
        edges.add(twocon);
        edges.add(threecon);
        edges.add(fourcon);

    }

}
