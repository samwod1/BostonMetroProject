import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class testRoute {
    Route route = new Route();

    @Test
    public void testShortRouteOutput() {
        Station a = NetworkConstructor.stnfromStr("OakGrove");
        Station b = NetworkConstructor.stnfromStr("Wellington");
        ArrayList<Station> rt = route.makeRoute(a, b);

        ArrayList<Station> expectedroute = new ArrayList<>();
        Station one = NetworkConstructor.stnfromStr("OakGrove");
        Station two = NetworkConstructor.stnfromStr("Malden");
        Station three = NetworkConstructor.stnfromStr("Wellington");

        expectedroute.add(one);
        expectedroute.add(two);
        expectedroute.add(three);

        assertEquals(rt,expectedroute);
    }

    @Test
    public void testConnectingRouteOutput() {
        Station a = NetworkConstructor.stnfromStr("OakGrove");
        Station b = NetworkConstructor.stnfromStr("Copley");
        ArrayList<Station> rt = route.makeRoute(a, b);

        ArrayList<Station> expectedroute = new ArrayList<>();
        Station one = NetworkConstructor.stnfromStr("OakGrove");
        Station two = NetworkConstructor.stnfromStr("Malden");
        Station three = NetworkConstructor.stnfromStr("Wellington");
        Station five = NetworkConstructor.stnfromStr("SullivanSquare");
        Station six = NetworkConstructor.stnfromStr("CommunityCollege");
        Station seven = NetworkConstructor.stnfromStr("NorthStation");
        Station eight = NetworkConstructor.stnfromStr("Haymarket");
        Station nine = NetworkConstructor.stnfromStr("GovernmentCenter");
        Station ten = NetworkConstructor.stnfromStr("ParkStreet");
        Station eleven = NetworkConstructor.stnfromStr("Boylston");
        Station twelve = NetworkConstructor.stnfromStr("Arlington");
        Station thrtn = NetworkConstructor.stnfromStr("Copley");

        expectedroute.add(one);
        expectedroute.add(two);
        expectedroute.add(three);
        expectedroute.add(five);
        expectedroute.add(six);
        expectedroute.add(seven);
        expectedroute.add(eight);
        expectedroute.add(nine);
        expectedroute.add(ten);
        expectedroute.add(eleven);
        expectedroute.add(twelve);
        expectedroute.add(thrtn);

        assertEquals(rt,expectedroute);
    }
}

