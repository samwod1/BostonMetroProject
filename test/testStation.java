import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class testStation {


    @Test
    public void testToStr() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);

        assertEquals(a.toString(), "Station{number='1', name='StnA', lines=[Green], connections=[2]}");

    }

    @Test
    public void testgetName() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);

        assertEquals(a.getName(), "StnA");
    }

//    @Test
//    public void testgetNumbersAsint() {
//        ArrayList<String> alines = new ArrayList();
//        alines.add("Green");
//        ArrayList<Integer> akon = new ArrayList();
//        akon.add(2);
//        Station a = new Station("1","StnA", alines, akon);
//
//        assertEquals(a.getNumberAsint(), '1');
//    }

    @Test
    public void testsetName() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);
        assertEquals(a.getName(), "StnA");
        a.setName("StnB");
        assertEquals(a.getName(), "StnB");
    }

    @Test
    public void testgetLines() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);
        assertEquals(a.getLines(), alines);
    }

    @Test
    public void testsetLines() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);
        assertEquals(a.getLines(), alines);
        alines.add("Yeller");
        a.setLines(alines);
        assertEquals(a.getLines(), alines);
    }

    @Test
    public void testgetConns() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);
        assertEquals(a.getConnections(), akon);
    }

    @Test
    public void testsetConns() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);
        assertEquals(a.getConnections(), akon);
        akon.add(3);
        a.setConnections(akon);
        assertEquals(a.getConnections(), akon);
    }









}