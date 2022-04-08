import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class testNetworkConstructor {

    @Test
    public void testcreateStations() {
        ArrayList<Station> stations = NetworkConstructor.createStations();
        Integer len = stations.size();
        Integer numstations = 124;

        assertEquals(len, numstations);
    }


    @Test
    public void teststnfromStr() {
        Station a = NetworkConstructor.stnfromStr("OakGrove");
        Station b = NetworkConstructor.getStnFromInt(1);

        assertEquals(a,b);
    }

    @Test
    public void testgetStnFromInt() {
        Station a = NetworkConstructor.getStnFromInt(1);
        Station b = NetworkConstructor.stnfromStr("OakGrove");

        assertEquals(a,b);
    }

}
