import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class testLine {

    @Test
    public void testToStr() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);

        ArrayList<Station> stns = new ArrayList<Station>();
        stns.add(a);
        Line l = new Line("LineL", stns);
        assertEquals(l.toString(), "Line{name='LineL', stations=[Station{number='1', name='StnA', lines=[Green], connections=[2]}]}");
    }

    @Test
    public void testgetStation() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);

        ArrayList<Station> stns = new ArrayList<Station>();
        stns.add(a);
        Line l = new Line("LineL", stns);

        assertEquals(l.getStations(), stns);
    }

    @Test
    public void testaddStation() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);

        ArrayList<Station> stns = new ArrayList<Station>();
        stns.add(a);
        Line l = new Line("LineL", stns);

        assertEquals(l.getStations(), stns);

        Station b = new Station("1","StnB", alines, akon);
        l.addStation(b);
        stns.add(b);

        assertEquals(l.getStations(), stns);

    }

    @Test
    public void testsetStations() {
        ArrayList<String> alines = new ArrayList();
        alines.add("Green");
        ArrayList<Integer> akon = new ArrayList();
        akon.add(2);
        Station a = new Station("1","StnA", alines, akon);

        ArrayList<Station> stns = new ArrayList<Station>();
        stns.add(a);
        Line l = new Line("LineL", stns);

        assertEquals(l.getStations(), stns);

        Station b = new Station("1","StnB", alines, akon);
        stns.add(b);
        l.setStations(stns);

        assertEquals(l.getStations(), stns);

    }
}
