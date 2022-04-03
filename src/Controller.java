public class Controller {

    //need to make a function to tell when there's a change of line


    public static void main(String[] args) {
        NetworkConstructor nwc = new NetworkConstructor();
        Route route = new Route();

        Station stn1 = nwc.stations.get(11);
        System.out.println(stn1);
        Station stn2 = nwc.stations.get(0);
        System.out.println(stn2);

        System.out.println(route.makeRoute(stn2,stn1));
    }

}
